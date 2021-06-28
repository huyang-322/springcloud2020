package com.hyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/25
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPayment9003Main {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment9003Main.class,args);
    }
}
