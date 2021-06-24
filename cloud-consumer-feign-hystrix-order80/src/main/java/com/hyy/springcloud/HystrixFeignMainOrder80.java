package com.hyy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/9
 * @Modified By:
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixFeignMainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignMainOrder80.class,args);
    }
}
