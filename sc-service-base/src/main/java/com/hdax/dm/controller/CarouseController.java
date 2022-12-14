package com.hdax.dm.controller;

import com.hdax.dm.dto.CarouselDto;
import com.hdax.dm.service.CarouseService;
import com.hdax.dm.utils.CommonResponse;
import com.hdax.dm.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/base")
public class CarouseController {

    @Autowired
    private CarouseService carouseService;

    @PostMapping(path = "/index/carousel")
    public CommonResponse<List<CarouselDto>> carousel(){
        List<CarouselDto> carouselDtos = carouseService.carousel();
        return ResponseUtils.returnSuccess(carouselDtos);
    }


}
