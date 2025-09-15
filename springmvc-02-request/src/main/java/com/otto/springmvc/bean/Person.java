package com.otto.springmvc.bean;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String username;
    private String password;
    private String cellphone;
    private Boolean agreement;
    private Address address;
    private String sex;
    private List<String> hobby;
    private String grade;
}
