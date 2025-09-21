package com.otto.mybatis.controller;

import com.otto.mybatis.bean.Order;
import com.otto.mybatis.mapper.OrderCustomerStepMapper;
import com.otto.mybatis.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    @Autowired
    private OrderCustomerStepMapper orderCustomerStepMapper;

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") Long orderId) {
        Order order = orderCustomerStepMapper.getOrderByIdAndCustomerAndOtherOrderStep(orderId);
        return order;
    }
}
