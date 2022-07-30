package com.hdax.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }

    /**
     *
     * 网关由三部分组成 route  一组断言predicates 一组过滤器（filter）
     * 这三部分即可以采用编程式完成 这种方式不推荐 推荐使用第二种
     */
}
