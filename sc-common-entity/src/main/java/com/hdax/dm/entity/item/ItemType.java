package com.hdax.dm.entity.item;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hdax.dm.entity.BaseTimeEntity;
import lombok.Data;

@Data
@TableName(value = "dm_item_type")
public class ItemType extends BaseTimeEntity {
    @TableId
    private Long id;
    private String itemType;
    private Long level;
    private Long parent;
    private String aliasName;
    @TableField(value = "`key`")
    private Long key;

}
