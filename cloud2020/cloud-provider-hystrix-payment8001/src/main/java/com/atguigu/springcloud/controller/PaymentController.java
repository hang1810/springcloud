package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo(@PathVariable Integer id){
        String result = paymentService.paymentInfo(id);
        log.info("@@@@@@@result="+result);
        return result;
    }

    @RequestMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_Time(@PathVariable Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("@@@@@@@result="+result);
        return result;
    }
}
