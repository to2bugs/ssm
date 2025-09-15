package com.otto.springmvc.bean;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
}
