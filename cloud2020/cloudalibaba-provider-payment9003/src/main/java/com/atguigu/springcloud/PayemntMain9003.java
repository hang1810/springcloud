package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Hang
 * @date 2020-06-28 15:58
 */
@EnableDiscoveryClient
@SpringBootApplication

public class PayemntMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(PayemntMain9003.class);
    }
}
