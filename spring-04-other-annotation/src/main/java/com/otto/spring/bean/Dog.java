package com.otto.spring.bean;

import lombok.Data;

@Data
public class Dog {
    private String name;
    private Integer age;

    public Dog() {
        System.out.println("Dog的构造函数");
    }
}
