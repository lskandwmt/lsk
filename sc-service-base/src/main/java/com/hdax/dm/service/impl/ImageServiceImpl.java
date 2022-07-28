package com.hdax.dm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.dm.entity.base.Image;
import com.hdax.dm.mappers.ImageMapper;
import com.hdax.dm.service.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {
}
