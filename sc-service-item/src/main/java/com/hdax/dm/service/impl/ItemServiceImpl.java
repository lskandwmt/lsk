package com.hdax.dm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.dm.dto.ItemDto;
import com.hdax.dm.entity.base.Image;
import com.hdax.dm.entity.item.Item;
import com.hdax.dm.feign.ImageFeign;
import com.hdax.dm.mappers.ItemMapper;
import com.hdax.dm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper,Item> implements ItemService {

    @Autowired
    private ImageFeign imageFeign;


    @Override
    public ItemDto item(Long id) {
        Item item = baseMapper.selectById(id);

        Image image = imageFeign.image(item.getId());
//        item.setImgUrl(i);
        return ItemDto.builder()
                .itemName(item.getItemName())
                .imgUrl(image.getImgUrl())
                .build();
    }
}
