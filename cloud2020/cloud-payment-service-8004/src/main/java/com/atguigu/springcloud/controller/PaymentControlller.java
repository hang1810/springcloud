package com.atguigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentControlller {


    @Value("${server.port}")
    private String serverPort;



    @GetMapping(value = "/payment/zk")
    public String paymentZk(){
             return "springcloud with zookeeper  serverPort="+serverPort+"\t"+ UUID.randomUUID().toString();
    }


}
