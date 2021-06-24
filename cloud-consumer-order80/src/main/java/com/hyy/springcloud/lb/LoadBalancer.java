package com.hyy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/8
 * @Modified By:
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> instances);
}
