package com.hyy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/8
 * @Modified By:
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current =this.atomicInteger.get();
//            next =current+1;
            next=current+1;
        }while (!atomicInteger.compareAndSet(current,next ));
        System.out.println("###########next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = getAndIncrement()%instances.size();
        return instances.get(index);
    }
}
