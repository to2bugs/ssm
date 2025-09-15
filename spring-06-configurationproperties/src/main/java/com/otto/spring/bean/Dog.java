package com.otto.spring.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 * @Value("字面值")
 * @Value("${表达式}") 从配置文件中取出对应的值
 * @Value("#{Spring表达式}") Spring表达式spel
 *      T()表示静态调用
 */
@Component
@Data
public class Dog {
    @Value("#{T(java.util.UUID).randomUUID().toString()}")
    private String id;

    @Value("${dog.name}")
    private String name;

    @Value("#{23*34}")
    private Integer age;

    @Value("${dog.color}")
    private String color;

    @Value("#{\"Hello Spring Boot\".substring(2)}")
    private String msg;

    @Value("#{1 > 2 ? 'false' : 'true'}")
    private String flag;

    public Dog() {
        System.out.println("Dog构造函数......");

    }
}
