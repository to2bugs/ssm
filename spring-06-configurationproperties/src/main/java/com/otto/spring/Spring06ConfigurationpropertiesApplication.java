package com.otto.spring;

import com.otto.spring.bean.Cat;
import com.otto.spring.bean.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
public class Spring06ConfigurationpropertiesApplication {

    public static void main(String[] args) throws FileNotFoundException {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring06ConfigurationpropertiesApplication.class, args);

        // Dog dog = ioc.getBean(Dog.class);
        // System.out.println(dog);

        // Cat cat = ioc.getBean(Cat.class);
        // System.out.println(cat);

        File file = ResourceUtils.getFile("classpath:cat.properties");
        System.out.println(file.getAbsolutePath());


    }

}
