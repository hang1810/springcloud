package com.hang.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author Hang
 * @date 2020-07-05 16:37
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(444,"服务降级返回，--PaymentFallbackService",new Payment(id,"errorSerieal"));
    }
}
