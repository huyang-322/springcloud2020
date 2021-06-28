package com.hyy.springcloud.service;


import com.hyy.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/paymentSql/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id);
}
