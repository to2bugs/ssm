package com.otto.spring.config;

import com.otto.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfiguration {

    @Bean
    public Car car01() {
        Car car = new Car();
        car.setStyle("EV");
        car.setCarName("汉");

        return car;
    }

    @Bean
    public Car car02() {
        Car car = new Car();
        car.setStyle("EV");
        car.setCarName("唐L");

        return car;
    }
}
