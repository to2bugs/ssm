package com.otto.spring12aopround;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 环绕通知
 * @Around 可以控制目标对象方法是否执行，以及修改其执行的结果
 */
@SpringBootApplication
public class Spring12AopRoundApplication {

    public static void main(String[] args) {

        SpringApplication.run(Spring12AopRoundApplication.class, args);
    }

}
