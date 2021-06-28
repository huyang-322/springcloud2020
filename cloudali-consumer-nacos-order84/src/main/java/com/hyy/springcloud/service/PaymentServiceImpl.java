package com.hyy.springcloud.service;

import com.hyy.springcloud.entities.CommonResult;
import com.hyy.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/28
 * @Modified By:
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public CommonResult getPayment(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
