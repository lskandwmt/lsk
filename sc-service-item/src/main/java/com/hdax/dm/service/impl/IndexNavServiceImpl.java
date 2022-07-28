package com.hdax.dm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.dm.feign.ImageFeign;
import com.hdax.dm.dto.HotItemDto;
import com.hdax.dm.dto.IndexNavDto;
import com.hdax.dm.entity.base.Image;
import com.hdax.dm.entity.item.Item;
import com.hdax.dm.entity.item.ItemType;
import com.hdax.dm.mappers.ItemTypeMapper;
import com.hdax.dm.service.IndexNavService;
import com.hdax.dm.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexNavServiceImpl extends ServiceImpl<ItemTypeMapper, ItemType> implements IndexNavService {

    @Autowired
    private ItemService service;
    @Autowired
    private ImageFeign imageFeign;

    @Override
    public List<IndexNavDto> nav() {
        QueryWrapper<ItemType> wrapper = new QueryWrapper<>();
        wrapper.eq("level",1L);
        wrapper.eq("parent",0L);
        List<ItemType> firstType  = list(wrapper);
        List<IndexNavDto> dtos =  new ArrayList<>();

        firstType.forEach(itemType -> {
            QueryWrapper<ItemType> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("level",2L);
            wrapper1.eq("parent",itemType.getId());
            List<ItemType> secondType  = list(wrapper1);
            List<IndexNavDto> children =  new ArrayList<>();
            secondType.forEach(itemType1 -> {
               children.add(IndexNavDto.builder()
                    .id(itemType1.getId())
                    .parent(itemType1.getParent())
                    .level(itemType1.getLevel())
                    .itemType(itemType1.getItemType())
                    .aliasName(itemType1.getAliasName())
                    .build());
            });

            //热门商品
            QueryWrapper<Item> queryWrapper =  new QueryWrapper<>();
            queryWrapper.eq("itemType1Id",itemType.getId());
            queryWrapper.eq("isBanner",1L);
            queryWrapper.eq("isRecommend",1L);
            List<Item> items = service.page(new Page<Item>(1,5),queryWrapper ).getRecords();

            List<HotItemDto> hotItemDtos = new ArrayList<>();
            items.forEach(item -> {
                HotItemDto hotItemDto = new HotItemDto();
                BeanUtils.copyProperties(item,hotItemDto);
                Image image = imageFeign.image(item.getId());
                hotItemDto.setImgUrl(image == null || image.getImgUrl() == null ?"":image.getImgUrl());
                hotItemDtos.add(hotItemDto);
            });

            dtos.add(IndexNavDto.builder()
                    .id(itemType.getId())
                    .parent(itemType.getParent())
                    .level(itemType.getLevel())
                    .itemType(itemType.getItemType())
                    .aliasName(itemType.getAliasName())
                    .children(children)
                    .hotItems(hotItemDtos)
                    .build());

            //查询二级分类

        });


        // 只能赋值实体类 此类进行取值存值是靠反射来实现 而反射会消耗大量的内存 运算能力
        //有一个性能较好的mapstruct 一个结构化的映射
//        BeanUtils.copyProperties();

        // 一级分类
        // 二级分类
        // 根据一级分类 id 查询热门商品
            //每个商品的图片

        return dtos;
    }
}
