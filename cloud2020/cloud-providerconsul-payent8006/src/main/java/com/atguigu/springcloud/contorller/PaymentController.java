package com.atguigu.springcloud.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentZk(){
        return "springcloud with zookeeper  serverPort="+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
