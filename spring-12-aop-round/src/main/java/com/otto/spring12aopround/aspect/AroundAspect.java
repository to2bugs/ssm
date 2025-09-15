package com.otto.spring12aopround.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 环绕通知：当目标对象的方法出现异常时，必须抛出以便让下一个执行的切面类能够感知到出了异常
 */
@Component
@Aspect
public class AroundAspect {

    @Pointcut(value = "execution(Integer com.otto.spring12aopround.calc.MathCalculator.*(..))")
    public void pointCut() {}

    /**
     * 环绕通知有固定写法
     *  Object: 返回值
     *  ProceedingJoinPoint 是JoinPoint的子接口，意思为可以处理的连接点
     *      所以 joinPoint.proceed()表示执行目标对象某个方法的意思，类似于反射的method.invoke()
     */
    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;

        // 获取目标对象方法的参数
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        // 【 前置通知 】
        System.out.println("【around before通知】" + methodName + "()方法执行，参数: " + Arrays.asList(args));

        try {

            // 执行目标对象的方法，并返回值proceed
            // Object proceed = joinPoint.proceed(); // 无参
            proceed = joinPoint.proceed(args); // 也可以有参

            // 【 返回通知 】
            System.out.println("【around return通知】" + methodName + "()方法执行，返回值: " + proceed);

        } catch (Throwable e) {
            // 【 异常通知 】
            System.out.println("【around throwing通知】" + methodName + "()方法执行出错，异常原因: " + e.getMessage());
            throw e; // 很重要，必须抛出让下一个执行的切面类能够感知到出了异常
        } finally {
            // 【 后置通知 】
            System.out.println("【around after通知】" + methodName + "()方法执行完毕");
        }


        return proceed;
    }
}
