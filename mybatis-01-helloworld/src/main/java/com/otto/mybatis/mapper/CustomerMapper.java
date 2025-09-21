package com.otto.mybatis.mapper;

import com.otto.mybatis.bean.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {

    /**
     * 按照id查询客户以及其下的所有订单
     * 一对多的关系
     */
    Customer getCustomerByIdWidthOrders(@Param("id") Long id);

    /**
     * 查询所有客户的所有订单
     */

}
