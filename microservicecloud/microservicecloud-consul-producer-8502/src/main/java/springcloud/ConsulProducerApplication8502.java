package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //服务发现
public class ConsulProducerApplication8502 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProducerApplication8502.class,args);
    }
}
