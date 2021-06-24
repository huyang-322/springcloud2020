package com.hyy.myRuler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/8
 * @Modified By:
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRuler(){
        //定义为随机
        return new RandomRule();
        //先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重
//        return new RetryRule();
        //对RoundRobinRule的扩展,响应速度越快的实例选择权重越大，越容易被选择 (响应速度一样的话，还是轮询)
//        return new WeightedResponseTimeRule();
    }
}
