package com.hyy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hyy.springcloud.entities.CommonResult;
import com.hyy.springcloud.entities.Payment;
import com.hyy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/25
 * @Modified By:
 */
@RestController
public class ConsumerController {

    @Value("${service-url.nacos-user-service}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/paymentSql/{id}")
//    @SentinelResource(value = "fallback" )//没有配置
//    @SentinelResource(value = "fallback",fallback ="handlerFallback" )//fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
                        exceptionsToIgnore ={IllegalArgumentException.class} )
    public CommonResult getPayment(@PathVariable("id") Long id){
        CommonResult result = restTemplate.getForObject(url + "/paymentSql/" + id, CommonResult.class);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    //本例是fallback
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    @Resource
    private PaymentService paymentService;
    @GetMapping(value = "/feign/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id)
    {
        return paymentService.getPayment(id);
    }

}
