package com.otto.mybatis.bean;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Long id;
    private String customerName;
    private String phone;
    // 一对多的关系
    List<Order>  orders;
}
