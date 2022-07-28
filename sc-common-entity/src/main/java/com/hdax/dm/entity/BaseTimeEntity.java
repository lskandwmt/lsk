package com.hdax.dm.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseTimeEntity implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    protected LocalDateTime createdTime;

    @TableField(fill = FieldFill.UPDATE)
    protected LocalDateTime updatedTime;

}
