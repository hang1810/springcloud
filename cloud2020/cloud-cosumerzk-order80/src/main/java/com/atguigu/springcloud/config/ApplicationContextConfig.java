package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。  开启负载均衡  完成通过微服务名字从eureka获取服务
    //RIBBON 与 EUREKA 整合后consumer 可以直接调用服务而不用再关心地址和端口
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }


    //IRule：根据特定算法中从服务列表中选取一个要访问的服务
//    @Bean
//    public IRule myRule()
//    {
//        //return new RoundRobinRule();
//        //return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
//        return new RetryRule();
//    }
}

//@Bean
//public UserServcie getUserServcie()
//{
//	return new UserServcieImpl();
//}
// applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">