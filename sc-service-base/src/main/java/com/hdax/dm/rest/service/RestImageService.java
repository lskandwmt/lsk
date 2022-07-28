package com.hdax.dm.rest.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hdax.dm.api.ImageControllerApi;
import com.hdax.dm.entity.base.Image;
import com.hdax.dm.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 远程调用服务接口（图片服务提供者）
 */
@Service
public class RestImageService implements ImageControllerApi {

    @Autowired
    private ImageService imageService;

    @Override
//    @PostMapping(path = "/rest/image")
    public Image image(@RequestParam("targetId")Long targetId) {
        QueryWrapper<Image> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",2L);
        queryWrapper.eq("category",1L);
        queryWrapper.eq("targetId",targetId);
        return imageService.getOne(queryWrapper);
    }
}
