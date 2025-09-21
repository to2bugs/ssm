package com.otto.mybatis.mapper;

import com.otto.mybatis.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    /**
     * 按照id查询订单以及下单的客户信息
     * 一对一的关系
     */
    Order getOrderByIdWithCustomer(@Param("id") Long id);
}
