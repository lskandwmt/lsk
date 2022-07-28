package com.hdax.dm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient //注册中心客户端（eureka-server）
//@EnableDiscoveryClient //注册中心客户端(通用)
@EnableFeignClients // 开启HTTP远程调用
@MapperScan(basePackages = "com.hdax.dm.mappers")
public class BaseMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseMainApplication.class,args);
    }
}
