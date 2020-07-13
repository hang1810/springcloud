package com.hang.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Hang
 * @date 2020-07-04 15:57
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
//        测试线程束
        try{
            TimeUnit.SECONDS.sleep(900);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "----------testA";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"————————————TestB");
        return "----------testB";
    }

    @GetMapping("/testD")
    public String testD(){
        try{
            TimeUnit.SECONDS.sleep(1);
            log.info(" testD 测试RT");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "----------testD";
    }
    @GetMapping("/testE")
    public String testE(){

        log.info(" testE 测试异常比例");
        int age = 10/0;
        return "----------testE";
    }

    @GetMapping("/testF")
    public String testF(){

        log.info(" testF 测试异常数");
        int age = 10/0;
        return "----------testF";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealTestHotKey")//value 唯一标识 一般与GetMapping value 去掉 / 一致    自定义限流错误提示
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){//required=false  参数可传可不传

        log.info(" testF testHotKey");
        return "----------testHotKey";
    }

        public String dealTestHotKey(String p1, String p2, BlockException exception){
        return "----------dealTestHotKey";
    }
}
