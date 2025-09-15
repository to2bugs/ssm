package com.otto.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 定义切面类
 * @Aspect 告诉Spring该类不是普通类，而是一个切面类
 *
 * 编写通知方法，即类LogAspect中的方法
 *
 * 通过注解告诉Spring，切面类LogAspect中的方法何时何地执行
 * 何时
 *      @Before 方法执行之前执行
 *      @AfterReturning 方法执行返回结果之后执行
 *      @AfterThrowing 方法抛出异常后执行
 *      @After 方法执行之后，有返回值或有异常，执行
 * 何地:
 *      切入点表达式 execution("方法的全签名")
 *        方法的全签名:
 *          public int com.otto.spring.aop.calculator.MathCalculator.add(int i, int j) throws Exception
 *        方法的全签名的省略写法：[]中的内容都可以省略
 *          [public] int [com.otto.spring.aop.calculator.MathCalculator].add(int [i], int [j]) [throws Exception]
 *          int add(int , int)
 *          使用*代表所有的方法
 *              int *(int, int)
 *          通配符:
 *              *：表示任意字符
 *              ..: 在方法的参数位置，代表任意多个参数且任意类型
 *                  在包的位置，代表任意层级
 *
 * 被切入点表达式关联的所有对象，在注入容器时注入的都是代理对象
 * 通知方法的执行顺序：
 *  前置通知 -> 目标方法执行 -> 返回通知 -> 后置通知
 *                 |——> 异常通知 -> 后置通知
 *
 * 连接点JoinPoint包装了目标对象的方法的所有信息
 * JoinPoint.getArgs() 目标对象方法接受的参数值
 *
 *
 * MethodSignature能够使用的方法
 *   getName 获取目标对象的方法的名字
 *   getMethod
 *   getReturnType 获取返回值的类型 xxx.class
 *   getDeclaringType 获取目标对象的类型 xxx.class
 *   getModifiers 获取目标对象的方法的访问权限的修饰符
 *
 *
 * 多切面执行顺序
 *      默认首字母排序 AuthAspect -> LogAspect
 *      也可以通过注解@Order标注顺序，数字越小优先级越高越先执行
 */
@Order(1)
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(int com.otto.spring.calc.MathCalculator.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        // signature就是目标对象的方法的全签名
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String methodName = methodSignature.getName(); // 方法名
        Object[] args = joinPoint.getArgs(); // 参数值
        System.out.println("【切面 - 日志】【" + methodName + "】开始，参数列表: " + Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("【切面 - 日志】结束");
    }

    /**
     * 使用@AfterReturing的属性returning指定通知方法的哪个参数接受目标对象方法的返回值，这里是参数Object result
     *
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        // 获取返回值
        //Object result = methodSignature.getMethod().invoke(methodSignature.getDeclaringType().getConstructor().newInstance(), joinPoint.getArgs());
        System.out.println("【切面 - 日志】返回: " + result);
    }

    /**
     *
     * 使用@AfterThrowing的属性throwing指定通知方法中的哪个参数接受异常，这里是exception
     * 通常接受异常的参数使用比较大一点的Exception
     */
    @AfterThrowing(value = "execution(int com.otto.spring.calc.MathCalculator.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, RuntimeException exception) throws InvocationTargetException, IllegalAccessException {
        System.out.println("【切面 - 日志】异常: " + exception.getMessage());
    }


    // 切入点表达式args: 匹配方法参数是指定类型或其子类型的任何连接点
    // UserService.getUser(int i, int j) 也会被切入
    @Before("args(int, int)")
    public void start() {
        System.out.println("hahah");
    }

    // @args("注解的全类名") 表示参数是否是指定的注解
    @Before("@args(com.otto.spring.annotation.An) && within(com.otto.spring.service.UserService)")
    public void begin() {
        System.out.println("heheheheheheheh");
    }

    // @annotation("注解的全类名") 表示方法上是否有标注指定的注解
    @Before("@annotation(com.otto.spring.annotation.An)")
    public void anMethod() {
        System.out.println("标注在方法上哦");
    }
}
