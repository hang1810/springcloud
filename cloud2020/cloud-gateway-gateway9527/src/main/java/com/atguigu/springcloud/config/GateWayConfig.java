package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes=routeLocatorBuilder.routes();
//        http://news.baidu.com/guonei
        //访问 localhost:9527/guonei  ==> http://news.baidu.com/guonei
        routes.route("path_routh_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return  routes.build();
    }

    @Bean
    public RouteLocator customerRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes=routeLocatorBuilder.routes();
        //访问 localhost:9527/guoji  ==> http://news.baidu.com/guoji
        routes.route("path_routh_atguigu",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        return  routes.build();
    }
}
