package com.otto.springmvc.bean;


import com.otto.springmvc.annotation.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * do用来与数据库打交道
 */
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
