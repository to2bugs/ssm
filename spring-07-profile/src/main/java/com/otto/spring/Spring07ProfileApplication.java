package com.otto.spring;

import com.otto.spring.datasource.MyDatasource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Spring07ProfileApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc = SpringApplication.run(Spring07ProfileApplication.class, args);

        MyDatasource bean = ioc.getBean(MyDatasource.class);
        System.out.println(bean);

    }

}
