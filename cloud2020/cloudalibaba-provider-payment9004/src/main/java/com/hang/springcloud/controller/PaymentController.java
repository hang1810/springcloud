package com.hang.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200,"from serverport: t port:"+port+" id: "+id ,payment);
        return  result;
    }

    public static HashMap<Long,Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"hang001"));
        hashMap.put(2L,new Payment(2L,"hang002"));
        hashMap.put(3L,new Payment(3L,"hang003"));

    }
}
