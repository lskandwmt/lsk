package com.hdax.dm.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDto {
    private String imgUrl;
    private String itemName;
}
