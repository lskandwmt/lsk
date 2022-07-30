package com.hdax.dm.controller;


import com.hdax.dm.dto.IndexNavDto;
import com.hdax.dm.service.IndexNavService;
import com.hdax.dm.utils.CommonResponse;
import com.hdax.dm.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class IndexNavController {

    @Autowired
    private IndexNavService service;


    /**
     * 导航首页 （一级 二级 以及热门商品（1-5 ））
     * @return
     */
    @PostMapping(path = "index/nav")
    public CommonResponse<List<IndexNavDto>> nav(){
        return ResponseUtils.returnSuccess(service.nav());
    }


}