package com.otto.spring.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解@UUID
 * 要求：
 *      1，标注在任何Bean的String属性上
 *      2，在从ioc容器中获取到Bean实例时，这个属性就是一个随机值
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Uuid {
}
