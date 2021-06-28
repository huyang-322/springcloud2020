package com.hyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/25
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerNacos84 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacos84.class,args);
    }
}
