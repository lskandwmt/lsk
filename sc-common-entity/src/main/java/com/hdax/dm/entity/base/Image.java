package com.hdax.dm.entity.base;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "dm_image")
public class Image {
    @TableId
    private Long id;
    private String imgUrl;
    private Long targetId;
    private Long sort;
    private Long type;
    private Long category;

}
