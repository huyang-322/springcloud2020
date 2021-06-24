package com.hyy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/10
 * @Modified By:
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "FeignClient 的 fallback 的 paymentInfo_Timeout ";
    }

    @Override
    public String payment_ok(Integer id) {
        return "FeignClient 的 fallback 的 payment_ok ";
    }
}
