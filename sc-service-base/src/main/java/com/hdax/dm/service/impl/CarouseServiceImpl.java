package com.hdax.dm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.dm.dto.CarouselDto;
import com.hdax.dm.entity.base.Image;
import com.hdax.dm.entity.item.Item;
import com.hdax.dm.feign.ItemFeign;
import com.hdax.dm.mappers.CarouseMapper;
import com.hdax.dm.mappers.ImageMapper;
import com.hdax.dm.service.CarouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouseServiceImpl  extends ServiceImpl<ImageMapper,Image> implements CarouseService {

    @Autowired
    private ItemFeign itemFeign;

    @Override
    public List<CarouselDto> carousel() {
        //设置分页
        IPage<Image> page = new Page<>(1,4);
        QueryWrapper<Image> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",1L);
        queryWrapper.eq("category",1L);
        queryWrapper.orderByDesc("sort");
        List<Image> images  = this.page(page,queryWrapper).getRecords();
        List<CarouselDto> carouselDtos = new ArrayList<>();
        images.forEach(image -> {
            Item item = itemFeign.item(image.getTargetId());
            carouselDtos.add(CarouselDto.builder()
                    .id(image.getTargetId())
                    .imgUrl(image.getImgUrl())
                    .itemName(item.getItemName())
                    .minPrice(item.getMinPrice())
                    .build());
        });

        return carouselDtos;
    }
}
