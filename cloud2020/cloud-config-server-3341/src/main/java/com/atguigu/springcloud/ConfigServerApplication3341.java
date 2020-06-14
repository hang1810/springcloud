package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Description:
 *
 * @author JourWon
 * @date 2019/12/21 11:55
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerApplication3341 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication3341.class, args);
    }

}
