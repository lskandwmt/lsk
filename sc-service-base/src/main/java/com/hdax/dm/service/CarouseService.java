package com.hdax.dm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.dm.dto.CarouselDto;
import com.hdax.dm.entity.base.Image;

import java.util.List;

public interface CarouseService extends IService<Image> {

    List<CarouselDto>  carousel();
}
