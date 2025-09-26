package com.otto.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.otto.mybatisplus.mapper")
@SpringBootApplication
public class MybatisPlus01DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus01DemoApplication.class, args);
    }

}
