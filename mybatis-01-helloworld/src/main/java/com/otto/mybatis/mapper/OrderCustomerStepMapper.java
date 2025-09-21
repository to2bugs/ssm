package com.otto.mybatis.mapper;

import com.otto.mybatis.bean.Customer;
import com.otto.mybatis.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MyBatis 的自动分步查询机制
 * 在 association 和 collection 的封装过程中，可以使用 select 和 column 指定分布查询的逻辑
 * 1. select 指定分布查询调用的方法
 * 2. column 指定分布查询传递的参数
 *      传递单个：直接写列名，表示将这些列的值作为参数传递给下一个查询
 *      传递多个：column = "{@Param的参数名1=col1, @Param的参数名2=col2}"，下一个查询使用prop1、prop2的取值
 */
@Mapper
public interface OrderCustomerStepMapper {

    /**
     * 原生的分布
     * 先查询出客户，再根据客户表中的订单id查询出所有的订单
     *
     */
    // 查询客户
    Customer getCustomerById(@Param("id") Long id);
    // 查询订单
    List<Order> getOrdersByCustomerId(@Param("customerId") Long customerId);



    /**
     * MyBatis分步查询案例一：
     *  查询客户 + 查询客户的订单，这两步由MyBatis自动的完成
     */
    Customer getCustomerByIdAndOrdersStep(@Param("id") Long id);



    /**
     * 分步查询案例二：
     *  按照id查询订单以及下单的客户
     */
    Order getOrderByIdAndCustomerStep(@Param("id") Long id);


    /**
     * 分步查询案例三：
     *  按照id查询订单以及下单的客户信息以及此客户下的所有订单
     *  最后一层必须使用 resultType，否则会出现栈溢出的现象
     *  因为 resultType 是默认封装，不关联其他的数据，即不会再触发继续的查询
     *
     *  resultMap 是自定义封装，关联其他的数据，启动继续的查询，可能会造成stack over flow的现象
     */
    Order getOrderByIdAndCustomerAndOtherOrderStep(@Param("id") Long id);
}
