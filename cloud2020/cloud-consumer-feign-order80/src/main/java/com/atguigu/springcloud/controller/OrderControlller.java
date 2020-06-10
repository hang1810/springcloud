package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.Service.PaymentFeignService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderControlller {

    @Resource
    private PaymentFeignService service;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("id:"+id);
        return  service.getPaymentById(id);
    }

    @RequestMapping("/consumer/payment/feign/timeout")
    public String  paymentFeignTimeout(){

        // openFeign-ribbon 客户端默认等待一分钟
        return service.paymentFeignTimeout();
    }
}
