package com.otto.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MyBatis Plus的分页
 * 1. 指定MyBatis Plus的分页插件
 * 2. Page<T>
 */
@SpringBootApplication
public class MybatisPlus02PageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus02PageApplication.class, args);
    }

}
