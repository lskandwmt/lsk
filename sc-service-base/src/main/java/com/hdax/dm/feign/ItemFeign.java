package com.hdax.dm.feign;

import com.hdax.dm.api.ItemControllerApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "dm-item")
@Component
public interface ItemFeign extends ItemControllerApi {

}
