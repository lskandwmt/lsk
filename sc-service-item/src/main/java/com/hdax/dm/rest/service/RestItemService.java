package com.hdax.dm.rest.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.dm.api.ItemControllerApi;
import com.hdax.dm.entity.item.Item;
import com.hdax.dm.mappers.ItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RestItemService extends ServiceImpl<ItemMapper, Item> implements ItemControllerApi {
    @Override
    public Item item(@RequestParam("id") Long id) {
        return baseMapper.selectById(id);
    }
}
