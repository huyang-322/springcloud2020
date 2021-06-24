package com.hyy.springcloud.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/10
 * @Modified By:
 */
@Configuration
public class FeignConfig {

    //feign 的配置
    @Bean
    public Retryer retryer(){
        return new Retryer.Default(100,1000,5);
    }
}
