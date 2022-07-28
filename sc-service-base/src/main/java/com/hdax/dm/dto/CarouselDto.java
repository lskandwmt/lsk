package com.hdax.dm.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarouselDto {
    private Long id;//节目主键
    private String itemName;//节目名称
    private Double minPrice;//最低价格
    private String imgUrl;//轮播图url
}
