package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
//        return  new RandomRule();//定义为随机
        return new RandomRule_ZY();// 我自定义为每台机器5次
    }
}
