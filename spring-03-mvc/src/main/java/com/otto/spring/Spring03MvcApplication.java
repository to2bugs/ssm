package com.otto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Spring03MvcApplication {

    public static void main(String[] args) {

        /**
         * 分层注解能起效，这些组件必须在主程序及其子包结构下，Spring默认会自动的扫描到这些组件
         * Spring为我们提供了快速的MVC分层注解
         * 1. @Controller 控制器
         * 2. @Service 服务层
         * 3. @Repository 持久层
         * 4. @Component 组件
         */
        SpringApplication.run(Spring03MvcApplication.class, args);
    }

}
