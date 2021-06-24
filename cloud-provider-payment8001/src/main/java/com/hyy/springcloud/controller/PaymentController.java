package com.hyy.springcloud.controller;

import com.hyy.springcloud.entities.CommonResult;
import com.hyy.springcloud.entities.Payment;
import com.hyy.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author hyy
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String server_port;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to here, O(∩_∩)O哈哈~";
    }


    @PostMapping("/payment/create")
    public CommonResult create( Payment payment){
        int result = paymentService.create(payment);
        log.info("#######插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入成功,server_port:"+server_port,result);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);

        log.info("#######查询结果："+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功,server_port:"+server_port,payment);
        }else {
            return new CommonResult(444,"查询失败");
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element :services){
            log.info("########element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb(){
        return server_port;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return server_port;
    }
}
