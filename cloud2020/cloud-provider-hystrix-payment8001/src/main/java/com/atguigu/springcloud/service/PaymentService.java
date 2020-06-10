package com.atguigu.springcloud.service;

import org.omg.CORBA.TIMEOUT;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo(Integer id){
        return "线程池： "+Thread.currentThread().getName()+" payment_od,id="+id+"\t"+"HELLO";
    }
    public String paymentInfo_TimeOut(Integer id){
        int tiemNumer=3;
        try {

            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池： "+Thread.currentThread().getName()+" payment_od,id="+id+"\t"+"HELLO"+"耗时"+tiemNumer+"秒";
    }
}
