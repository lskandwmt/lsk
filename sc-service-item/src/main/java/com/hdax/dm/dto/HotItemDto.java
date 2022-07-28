package com.hdax.dm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotItemDto {
    private Long id;//商品id；
    private String itemName;//商品名称
    private Double minPrice;//最低价格
    private String imgUrl;//图片海报
}
