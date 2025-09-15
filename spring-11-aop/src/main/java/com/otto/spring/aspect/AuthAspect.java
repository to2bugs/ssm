package com.otto.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Order(2)
@Aspect
@Component
public class AuthAspect {

    @Pointcut("execution(int com.otto.spring.calc.MathCalculator.*(..))")
    public void pointcut() {}

    @Before(value = "pointcut()")
    public void before() {
        System.out.println("【权限】前置");
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("【权限】返回值: " + result);
    }

    @AfterThrowing(value = "pointcut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, RuntimeException exception) {
        System.out.println("【权限】异常:" + exception.getMessage());
    }

    @After(value = "pointcut()")
    public void after() {
        System.out.println("【权限】后置:");
    }
}
