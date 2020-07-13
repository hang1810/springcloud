package com.hang.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author Hang
 * @date 2020-07-04 23:17
 */
public class CustomerBlockHandler {
    public static CommonResult HandlerException(BlockException exception){
        return new CommonResult(4444,"按照客户自定义,gloger --vaersion==1");
    }
    public static CommonResult HandlerException2(BlockException exception){
        return new CommonResult(4444,"按照客户自定义,gloger --vaersion==2");
    }
}
