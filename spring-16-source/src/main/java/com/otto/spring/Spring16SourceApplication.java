package com.otto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Spring16SourceApplication {

    public static void main(String[] args) {

        // SpringApplication.run(Spring16SourceApplication.class, args);

        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring.xml");

    }

}
