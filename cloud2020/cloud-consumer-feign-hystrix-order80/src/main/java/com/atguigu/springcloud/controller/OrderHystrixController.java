package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumenr/payment/hystrix/ok/{id}")
    public String paymentInfo(@PathVariable Integer id){
        String resullt =paymentHystrixService.paymentInfo(id);
        return resullt;
    }

    @GetMapping(value = "/consumenr/payment/hystrix/timeout/{id}")
    public String paymentInfo_Time(@PathVariable Integer id){
        String result = paymentHystrixService.paymentinfo_Tiemout(id);
        return result;
    }
}
