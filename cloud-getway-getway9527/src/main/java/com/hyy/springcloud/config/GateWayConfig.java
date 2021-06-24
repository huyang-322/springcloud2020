package com.hyy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/11
 * @Modified By:
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder.routes().
                route("payment_route",
                        r->r.path("/guonei")
                                .uri("http://news.baidu.com/guonei") ).build();
    }
}
