package com.hyy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/23
 * @Modified By:
 */
@RestController
@EnableBinding(Sink.class)
public class ReceiverMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String > message){
        System.out.println("#############2hao :"+message.getPayload().toString()+"\t"+"server post:"+serverPort);
    }
}
