package com.hang.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.hang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Hang
 * @date 2020-06-29 21:20
 */
@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")//没有配置 fallBack
    //@SentinelResource(value = "fallback",fallback = "handerFallback")//配置 fallBack=handerFallback 业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockException")//配置 blockHandler=blockException 负责Sentinel配置违规错误
    //@SentinelResource(value = "fallback",fallback = "handerFallback",blockHandler = "blockException")//配置 blockHandler=blockException  fallBack=handerFallback Sentinel配置违规错误、业务异常都能处理返回自定义储物
    @SentinelResource(value = "fallback",fallback = "handerFallback",blockHandler = "blockException",
                                exceptionsToIgnore = {IllegalArgumentException.class})//配置 blockHandler=blockException  fallBack=handerFallback Sentinel配置违规错误、业务异常都能处理返回自定义储物
    public CommonResult<Payment> fallBack(@PathVariable Long id ){
            CommonResult<Payment> result = restTemplate.getForObject(serverUrl+"/paymentSQL/"+id,CommonResult.class,id);
            if (id == 4 ){
                throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
            }else if (result.getData()==null){
                throw new NullPointerException("NullPointerException,空指针异常" );
            }
            return result;
    }

    //本例子是fallback
    public CommonResult handerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"逻辑异常 fallback返回指定异常内容"+e.getMessage(),payment);
    }

    //本例子是blockHandler
    public CommonResult blockException(@PathVariable Long id,BlockException exception){
        Payment payment = new Payment(id,"null");
        return new CommonResult(445,"blockHandler-sentinel 限流的错误提示,无此流水：BlockException"+exception.getMessage(),payment);
    }

    //=====openFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        return paymentService.paymentSql(id);
    }
}
