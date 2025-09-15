package com.otto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class Spring14TxIsolationApplication {

    public static void main(String[] args) {

        SpringApplication.run(Spring14TxIsolationApplication.class, args);
    }

}
