package com.otto.spring.bean;

import lombok.Data;

@Data
public class Person {
    private String name;
    private Integer age;
    private String gender;

    public Person() {
        System.out.println("Person的构造函数");
    }
}
