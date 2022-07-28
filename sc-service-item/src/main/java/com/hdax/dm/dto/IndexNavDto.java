package com.hdax.dm.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class IndexNavDto {
    private Long id;
    private String itemType;
    private Long level;
    private Long parent;
    private String aliasName;
    private List<IndexNavDto> children;
    private List<HotItemDto> hotItems;



}
