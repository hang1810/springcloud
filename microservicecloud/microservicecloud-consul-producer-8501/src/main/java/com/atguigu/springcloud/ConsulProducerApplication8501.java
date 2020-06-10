package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //服务发现
public class ConsulProducerApplication8501 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProducerApplication8501.class,args);
    }
}
