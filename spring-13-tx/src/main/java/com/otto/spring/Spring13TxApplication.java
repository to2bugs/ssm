package com.otto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement // 开启基于注解的自动化事务管理，通常定义在配置类上面
@SpringBootApplication
public class Spring13TxApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring13TxApplication.class, args);
    }

}
