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

            //ç­éšćć
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

            //æ„èŻąäșçș§ćç±»

        });


        // ćȘèœè”ćŒćźäœç±» æ­€ç±»èżèĄććŒć­ćŒæŻé ćć°æ„ćźç° èćć°äŒæ¶èć€§éçćć­ èżçźèœć
        //æäžäžȘæ§èœèŸć„œçmapstruct äžäžȘç»æćçæ ć°
//        BeanUtils.copyProperties();

        // äžçș§ćç±»
        // äșçș§ćç±»
        // æ čæźäžçș§ćç±» id æ„èŻąç­éšćć
            //æŻäžȘććçćŸç

        return dtos;
    }
}
