package com.hdax.dm.entity.item;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hdax.dm.entity.BaseTimeEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "dm_item")
public class Item extends BaseTimeEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String itemName;
    private String abstractMessage;
    private Long itemType1Id;
    private String itemType1Name;
    private Long itemType2Id;
    private String itemType2Name;
    private Long state;
    private String basicDescription;
    private String projectDescription;
    private String reminderDescription;
    private Double longitude;
    private Double latitude;
    private Long isBanner;
    private Long isRecommend;
    private Double avgScore;
    private Long commentCount;
    private Long cinemaId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double minPrice;
    private Double maxPrice;
    private Long ageGroup;
}
