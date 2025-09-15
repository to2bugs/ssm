package com.otto.spring;

import com.otto.spring.controller.UserController;
import com.otto.spring.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class Spring05InjectApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc = SpringApplication.run(Spring05InjectApplication.class, args);

        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);

        System.out.println("========== 感知接口 ==========");
        UserService userService = ioc.getBean(UserService.class);
        System.out.println("OS = " + userService.getOS());
    }

}
