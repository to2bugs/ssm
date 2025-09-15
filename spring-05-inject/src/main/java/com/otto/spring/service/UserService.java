package com.otto.spring.service;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * ioc容器中的名字是userService
 *
 * XXXAware 感知接口
 *  允许 Bean 在 Spring 容器中感知（aware）到容器提供的某些资源或上下文信息
 *  如果一个 Bean 实现了某个 Aware 接口，Spring 容器会在 Bean 初始化过程中自动注入相应的资源，从而让 Bean “感知”到这些信息
 */
@Service
public class UserService implements EnvironmentAware {
    private Environment environment;

    // Spring你用setter注入env
    @Override
    public void setEnvironment(Environment env) {
        this.environment = env;
    }

    public String getOS() {
        String os = this.environment.getProperty("OS");
        return os;
    }
}
