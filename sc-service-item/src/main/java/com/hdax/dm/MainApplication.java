package com.hdax.dm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient//注册中心的客户端 当服务端是eurekaserver 那么必须使用此注解 其他则用一下注解 EnableDiscoverClient 优势：针对性更强
//@EnableDiscoveryClient//（通用注解） 优势：通用性更强

@MapperScan(basePackages = "com.hdax.dm.mappers")
@EnableFeignClients//开启远程调用 连接
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
