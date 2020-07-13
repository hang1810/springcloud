package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentControlller {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "/payment/create")
    //注意不带这个RequestBody 写入数据库的将为空值
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入数据成功 serverPort:"+serverPort, result);
        }else {
            return new CommonResult(400,"插入数据失败 serverPort:"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        //@PathVariable("id")  localhost:8001/payment/get/1
        //@Param("id")  localhost:8001/payment/get/1?id=1
        Payment payment= paymentService.getPaymentById(id);
        log.info("id："+id);

        log.info("插入结果："+payment+"yes"+"12121"+"121");
        if(payment != null){
            return new CommonResult(200,"查询成功 serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(400,"没用对应的记录，查询id="+id+"   serverPort:"+serverPort,null);
        }
    }
        @GetMapping(value = "/payment/lb")
        public String   getPaymentLB(){
                    return  serverPort;
        }




    //	@Autowired
//	private DiscoveryClient client;
    @RequestMapping(value = "/payment/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }



    @RequestMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return " hi ,IAM PAYMENT ZIPKIN SEVER FALL BACK,WELCOME TO FUJIAN";
    }
}
