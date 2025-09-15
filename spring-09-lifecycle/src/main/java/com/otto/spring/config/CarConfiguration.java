package com.otto.spring.config;

import com.otto.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfiguration {

    @Bean
    public Car car() {
        Car car = new Car();
        car.setCarName("君越白金版");
        return car;
    }
}
