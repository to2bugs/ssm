package com.otto.spring.config;

import com.otto.spring.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfiguration {

    @Bean
    public Dog dog1() {
        Dog dog = new Dog();
        dog.setName("doggy");
        return dog;
    }

    @Bean
    public Dog dog2() {
        Dog dog = new Dog();
        dog.setName("wangwang");
        return dog;
    }
}
