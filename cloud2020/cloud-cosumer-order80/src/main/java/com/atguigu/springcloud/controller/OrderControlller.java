package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderControlller {
    // public static final String PAYMENT_URL="http://localhost:8001";
    //需要在config内RestTemplate 处添加注解 @LoadBalanced后，才可直接使用在eureka上注册的名字
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;



    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
             return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    //返回对象为响应体中数据转化对象，即json
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("id:"+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


    //返回对象w为ResponseEntity对象，包含了响应的一些重要信息，响应头，状态码，响应体
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCodeValue()+entity.toString());
            return entity.getBody();
        }else{
            return  new CommonResult<>(444,"操作失败");
        }
    }



    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/payment/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/discovery", Object.class);
    }

}
