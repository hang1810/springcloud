package com.atguigu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Hang
 * @date 2020-07-07 20:35
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.dao"})
public class MybatisConfig {
}
