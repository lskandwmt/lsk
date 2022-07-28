package com.hdax.dm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class ItemController {

    @PostMapping(path = "index/carousel")
    public Map<String,Object> carousel(){
        Map<String,Object> map =new HashMap<>();
        map.put("data",null);
        map.put("errorCode","0000");
        return null;
    }
}
