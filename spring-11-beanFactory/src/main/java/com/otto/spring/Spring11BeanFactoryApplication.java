package com.otto.spring;

import com.otto.spring.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * BeanFactory
 *      beanDefinitionMap Bean的定义信息，制造Bean的图纸 Map
 *      beanDefinitionNames 所有Bean的名字 List
 *      singletonObjects 按照图纸制造对象 -> 单例对象 HashMap
 *
 *      获取到的bean是由NamedBeanHolder封装来的
 *          beanName
 *          beanInstance
 *
 *      从以下三个Map中查找Bean，即三级缓存机制，使用来解决循环依赖的
 *          Map<String, Object>singltonObjects 单例对象池 “放置成品”
 *          Map<String, Object>ealySingltonObjects 单例对象池 “放置半成品”
 *          Map<String, ObjectFactory<?>>singltonFacotries 单例工厂
 */
@SpringBootApplication
public class Spring11BeanFactoryApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc = SpringApplication.run(Spring11BeanFactoryApplication.class, args);

        UserService userService = ioc.getBean(UserService.class);
    }

}
