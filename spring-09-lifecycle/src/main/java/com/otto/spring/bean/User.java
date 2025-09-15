package com.otto.spring.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 初始化周期：
 *      @PostConstruct -> initializingBean的afterPropertiesSet() -> @Bean指定的initMethod方法
 *
 * 创建周期：
 *      构造器 -> @Autoware的setter属性注入
 *
 * 运行周期
 *
 * 销毁周期：
 *      @PreDestroy -> DisposableBean的destory() -> @Bean指定的destroyMethod方法 -> 容器销毁结束
 */
@Data
public class User implements InitializingBean, DisposableBean {
    private String username;
    private String password;

    private Car car;

    public User() {
        System.out.println("User 构造器......");
    }

    // setter注入Bean的方式
    @Autowired
    public void setCar(Car car) {
        System.out.println("自动注入属性值: " + car);
        this.car = car;
    }

    // 初始化时调用的方法
    public void initUser() {
        System.out.println("@Bean注解指定的初始化initUser");
    }

    // 销毁时调用的方法
    public void destroyUser() {
        System.out.println("@Bean注解指定的销毁destroyUser");
    }

    // InitializingBean 接口
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean】afterPropertiesSet");
    }

    // DisposableBean 接口
    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean】destroy");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("【@PostConstruct】postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("【@PreDestroy】preDestroy");
    }
}
