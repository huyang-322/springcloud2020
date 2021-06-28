package com.hyy.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hyy.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Author:
 * @Description:
 * @Date:2021/6/28
 * @Modified By:
 */
@Component
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}
