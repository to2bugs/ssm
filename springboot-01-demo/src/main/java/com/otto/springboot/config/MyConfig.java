package com.otto.springboot.config;

import com.otto.springboot.bean.Dog;
import com.otto.springboot.properties.DogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Autowired
    DogProperties dogProperties;

    @Bean
    public Dog dog() {
        return new Dog(dogProperties);
    }
}
