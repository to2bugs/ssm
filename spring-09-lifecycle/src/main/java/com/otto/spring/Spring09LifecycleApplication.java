package com.otto.spring;

import com.otto.spring.bean.Department;
import com.otto.spring.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Spring09LifecycleApplication {

    /**
     * User 构造器......
     * 自动注入属性值: Car(carName=君越白金版)
     * 【postProcessBeforeInitialization】
     * 【@PostConstruct】postConstruct
     * 【InitializingBean】afterPropertiesSet
     * @Bean注解指定的初始化initUser
     * 【postProcessAfterInitialization】
     *
     * 运行......
     *
     * 【@PreDestroy】preDestroy
     * 【DisposableBean】destroy
     * @Bean注解指定的销毁destroyUser
     *
     */
    public static void main01(String[] args) {

        ConfigurableApplicationContext ioc = SpringApplication.run(Spring09LifecycleApplication.class, args);

        System.out.println("========== IOC容器创建完成 ==========");

        System.out.println("========== Bean ==========");

        User user = ioc.getBean(User.class);
        System.out.println("bean: " + user);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring09LifecycleApplication.class, args);

        Department deptBean = ioc.getBean(Department.class);
        System.out.println("bean: " + deptBean);
    }

}
