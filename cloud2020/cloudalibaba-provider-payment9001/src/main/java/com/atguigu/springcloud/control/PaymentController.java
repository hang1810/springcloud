package com.atguigu.springcloud.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hang
 * @date 2020-06-29 20:27
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/nacos/{id}")
    private String getPayment(@PathVariable("id") Integer id){
        return  "nacos registry ,serverport: "+port +"\t id:"+id;
    }
}
