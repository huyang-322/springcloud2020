package com.hyy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hyy
 */
@RestController
@RefreshScope
public class ConfigClientController {
    /**
     * 这里取的值是从github上取回来的
     */
    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String server_port;

    @RequestMapping("/configInfo")
    public String test(){
        return "configInfo: "+configInfo+"\t\t\n"+"server_port: "+server_port;
    }
}
