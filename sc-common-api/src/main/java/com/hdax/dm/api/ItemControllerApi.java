package com.hdax.dm.api;

import com.hdax.dm.entity.item.Item;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ItemControllerApi {

    @PostMapping(path = "/rest/item")
    Item item(@RequestParam("id")Long id);

}
