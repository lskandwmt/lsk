package com.hdax.dm.api;

import com.hdax.dm.entity.base.Image;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ImageControllerApi {

    @PostMapping(path = "/rest/image")
    Image image(@RequestParam("targetId")Long targetId);

}
