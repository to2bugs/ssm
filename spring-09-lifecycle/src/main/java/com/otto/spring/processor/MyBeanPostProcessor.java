package com.otto.spring.processor;

import com.otto.spring.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 拦截所有Bean的后置处理器
 *
 * 扩展知识
 * @Autowired是如何实现的
 * 1，专门有一个处理@Autowired注解的AutowiredAnnotationBeanPostProcessor
 * 2，每个Bean注入后，都会调用BeanPostProcessor的postProcessorBeforeInitialization()
 * 3, postProcessorBeforeInitialization()会利用反射得到当前Bean的所有属性，再利用反射得到属性上的注解，看是不是Autowire注解
 * 4，如果有，则去ioc容器中找到对应的组件，并赋值
 */
// @Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        var index = 0;
        if (beanName.lastIndexOf(".") == -1) {
            index = 0;
        } else {
            index = beanName.lastIndexOf(".") + 1;
        }
        System.out.println("「" + beanName.substring(index) + "」=>" + " MyBeanPostProcessor.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        var index = 0;
        if (beanName.lastIndexOf(".") == -1) {
            index = 0;
        } else {
            index = beanName.lastIndexOf(".") + 1;
        }
        System.out.println("「" + beanName.substring(index) + "」=>" + " MyBeanPostProcessor.postProcessAfterInitialization");

        if (bean instanceof User user) {
            user.setUsername("修改后的值哦");
        }
        return bean;
    }
}
