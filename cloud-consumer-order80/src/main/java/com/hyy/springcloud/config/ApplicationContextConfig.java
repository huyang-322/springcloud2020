package com.hyy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/7
 * @Modified By:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced//使用@LoadBalanced注解赋予RestTemplate负载均衡的能力(默认轮询)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
