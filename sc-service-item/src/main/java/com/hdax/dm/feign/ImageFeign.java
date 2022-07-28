package com.hdax.dm.feign;

import com.hdax.dm.api.ImageControllerApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "dm-base")
@Component
public interface ImageFeign  extends ImageControllerApi {



}
