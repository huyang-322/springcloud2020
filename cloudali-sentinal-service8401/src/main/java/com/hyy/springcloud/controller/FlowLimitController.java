package com.hyy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hyy
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA()
    {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info(Thread.currentThread().getName()+"\t"+"...testA");//<----
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        log.info("testD 测试异常比例");
        int age = 10/0;
        return "------testD";
    }

    @GetMapping("/testHostKey")
    @SentinelResource(value="testHostKey",blockHandler = "deal_testHotKey")
    public String testHostKey(@RequestParam (value = "p1",required = false) String p1,
                              @RequestParam (value = "p2",required = false) String p2){
//        int age = 10/0;//<----------------------------会抛异常的地方
        return "------testHostKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(e.getMessage());

        return "------deal_testHotKey,o(╥﹏╥)o";
    }
}
