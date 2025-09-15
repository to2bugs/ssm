package com.otto.spring;

import com.otto.spring.calc.MathCalculator;
import com.otto.spring.proxy.dynamic.DynamicProxy;
import com.otto.spring.proxy.statics.CalculatorStaticProxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SpringBootTest
class Spring10AopApplicationTests {

    @Autowired
    CalculatorStaticProxy calculatorStaticProxy;
    @Autowired
    MathCalculator mathCalculatorImpl; // 目标对象

    // 静态代理
    @Test
    void testMathCalculator() {
        Assertions.assertEquals(3, calculatorStaticProxy.add(1, 2));
    }


    /**
     * 动态代理
     * ClassLoader loader: 目标对象的类加载器
     * Class<?>[] interfaces: 目标对象实现的接口
     * InvocationHandler h: 类似于拦截器
     *      Object proxy: 代理对象，即proxyInstance
     *      Method method: 目标对象的方法
     *      Object[] args: 目标对象的方法的参数
     * 重要：
     *      JDK动态代理强制要求目标对象必须有接口，代理的也是接口中的方法
     *      如果目标对象没有接口，会报错！！！
     */
    @Test
    void testMathCalculatorDynamicProxy() {
        // 创建动态代理
        Object proxyInstance = Proxy.newProxyInstance(
                mathCalculatorImpl.getClass().getClassLoader(),
                mathCalculatorImpl.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 真正执行的目标对象的方法
                        Object result = method.invoke(mathCalculatorImpl, args);
                        return result;
                    }
                }
        );

        // 调用代理对象的方法，不过首先要将代理对象强转为目标对象
        MathCalculator mathCalculator  = (MathCalculator)proxyInstance;
        int r = mathCalculator.mul(12, 21);
        System.out.println(r);
    }


    /**
     * 测试自定义代理类
     */
    @Test
    void testSelfDefineDynamicProxy() {
        Object proxyInstance = DynamicProxy.getProxyInstance(mathCalculatorImpl);
        // 必须转换为接口类型哦
        MathCalculator mathCalculator = (MathCalculator)proxyInstance;
        int r = mathCalculator.mul(12, 21);
        System.out.println(r);
    }
}
