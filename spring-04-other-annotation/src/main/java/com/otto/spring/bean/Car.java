package com.otto.spring.bean;

import lombok.Data;

@Data
public class Car {
    private String type;
    private String carName;

    public Car() {
        System.out.println("~~~~ Car构造函数 ~~~~");
    }
}
