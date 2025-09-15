package com.otto.configuration;

import com.otto.configuration.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class Spring02ConfigurationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring02ConfigurationApplication.class, args);

        Map<String, Person> map = ioc.getBeansOfType(Person.class);
        System.out.println(map);
    }

}
