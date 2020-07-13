package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Hang
 * @date 2020-06-29 21:48
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3377.class,args);
    }
}
