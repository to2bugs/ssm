package com.otto.spring;

import com.otto.spring.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Spring08SpringXmlApplication {

    // public static void main(String[] args) {
    //     SpringApplication.run(Spring08SpringXmlApplication.class, args);
    // }

    // 使用Spring的main
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring.xml");

        System.out.println("========== 获取所有组件的名字 ==========");
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("========== 获取组件 ==========");
        Person wangwu = ioc.getBean("wangwu", Person.class);
        System.out.println(wangwu);
    }

}
