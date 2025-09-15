package com.otto.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 引入 spring-boot-starter-thymeleaf
 * static: 静态资源文件夹，存放js、css、...
 * resources: 页面模板文件夹
 * Model: 给页面共享数据
 *
 */
@SpringBootApplication
public class Springmvc04ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springmvc04ThymeleafApplication.class, args);
    }

}
