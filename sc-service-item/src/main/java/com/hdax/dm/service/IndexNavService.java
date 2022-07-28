package com.hdax.dm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.dm.dto.IndexNavDto;
import com.hdax.dm.entity.item.ItemType;

import java.util.List;

//首页分类导航 查询
public interface IndexNavService extends IService<ItemType> {
    /**
     * 查询导航
     * @return
     */
    List<IndexNavDto> nav();
}
