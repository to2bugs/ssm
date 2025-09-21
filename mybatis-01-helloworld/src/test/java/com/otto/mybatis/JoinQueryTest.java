package com.otto.mybatis;

import com.otto.mybatis.bean.Customer;
import com.otto.mybatis.bean.Order;
import com.otto.mybatis.mapper.CustomerMapper;
import com.otto.mybatis.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 */
@SpringBootTest
public class JoinQueryTest {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void testJoinQuery() {
        Order order = orderMapper.getOrderByIdWithCustomer(1L);
        System.out.println("order = " + order);
    }

    @Test
    public void testJoinQuery2() {
        Customer customer = customerMapper.getCustomerByIdWidthOrders(1L);
        System.out.println("customer = " + customer);
    }
}
