package com.hyy.springcloud.controller;

import com.hyy.springcloud.entities.CommonResult;
import com.hyy.springcloud.entities.Payment;
import com.hyy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @GetMapping("/payment/lb")
    public String getPaymentLb(){
        return server_port;
    }
}
