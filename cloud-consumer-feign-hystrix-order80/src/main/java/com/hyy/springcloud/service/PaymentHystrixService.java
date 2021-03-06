package com.hyy.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/9
 * @Modified By:
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback =PaymentHystrixServiceImpl.class )
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/ok/{id}")
    String payment_ok(@PathVariable("id") Integer id);
}
