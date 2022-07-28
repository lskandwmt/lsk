package com.hdax.dm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.dm.dto.ItemDto;
import com.hdax.dm.entity.item.Item;

public interface ItemService  extends IService<Item> {

    ItemDto item(Long id);

}
