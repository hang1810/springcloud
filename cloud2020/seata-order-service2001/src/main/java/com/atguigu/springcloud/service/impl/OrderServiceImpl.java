package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hang
 * @date 2020-07-07 20:18
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    /*
    *  订单创建--调用库存扣减--调用账户扣减--订单状态变更
    * */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("-->开始新建订单");
        orderDao.create(order);


        log.info("-->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-->订单微服务开始调用库存，做扣减end");

        log.info("-->订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(),order.getCount());
        log.info("-->订单微服务开始调用账户，做扣减end");



        //4修改订单状态，从0-->1 代表完成
        log.info("-->订单微服务开始调用账户，做扣减begin");
        orderDao.update(order.getUserId(),0);
        log.info("-->订单结束");
    }
}
