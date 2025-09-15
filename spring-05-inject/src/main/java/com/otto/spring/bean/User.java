package com.otto.spring.bean;

import lombok.Data;

@Data
public class User {
    private String name;
    private Integer age;
    private String gender;

    public User() {
        System.out.println("~~~~~~~ User Constructor ~~~~~~~");
    }
}
