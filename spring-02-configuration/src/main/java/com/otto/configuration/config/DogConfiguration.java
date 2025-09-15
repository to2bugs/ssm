package com.otto.configuration.config;

import com.otto.configuration.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置类也是一个组件
 */
@Import(Dog.class)
@ComponentScan(basePackages = "com.otto")
@Configuration
public class DogConfiguration {

    @Bean("dog")
    public Dog dog() {
        Dog dog = new Dog();
        return dog;
    }
}
