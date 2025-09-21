package com.otto.mybatis;

import com.otto.mybatis.bean.Customer;
import com.otto.mybatis.bean.Order;
import com.otto.mybatis.mapper.OrderCustomerStepMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StepTest {

    @Autowired
    OrderCustomerStepMapper orderCustomerStepMapper;

    // 原生分步，需要手动调用两次方法
    @Test
    public void testStep01() {
        Customer customer = orderCustomerStepMapper.getCustomerById(1L);
        List<Order> orders = orderCustomerStepMapper.getOrdersByCustomerId(customer.getId());
        customer.setOrders(orders);
        System.out.println(customer);
    }


    /**
     *
     */
    @Test
    public void testStep02() {
        Customer customer = orderCustomerStepMapper.getCustomerByIdAndOrdersStep(1L);
        System.out.println("customer = " + customer);
    }

    /**
     *
     */
    @Test
    public void testStep03() {
        Order order = orderCustomerStepMapper.getOrderByIdAndCustomerStep(1L);
        System.out.println("order = " + order);
    }


    /**
     *
     */
    @Test
    public void testStep04() {
        Order order = orderCustomerStepMapper.getOrderByIdAndCustomerAndOtherOrderStep(1L);
        System.out.println("order = " + order);
    }
}
