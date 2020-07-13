package com.hang.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Hang
 * @date 2020-07-05 16:35
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)//指定错误返回走那个类
public interface PaymentService {
    @GetMapping("/paymentSQL/{id}") // 与微服务nacos-payment-provider 上的接口地址一致
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
