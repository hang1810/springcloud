package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Hang
 * @date 2020-07-07 20:02
 */
@Mapper
public interface OrderDao {

    //新建订单
    void create(Order order);

    //2 修改订单状态 从0-->1
    void update(@Param("userId") Long userId,@Param("sratus") Integer status);
}
