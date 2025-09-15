package com.otto.spring.proxy.dynamic;

import com.otto.spring.log.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 自定义动态代理类 DynamicProxy
 * Proxy.newProxyInstance()方法的参数
     * ClassLoader loader: 目标对象的类加载器
     * Class<?>[] interfaces: 目标对象实现的接口
     * InvocationHandler h: 类似于拦截器
     *      Object proxy: 代理对象，即proxyInstance
     *      Method method: 目标对象的方法
     *      Object[] args: 目标对象的方法的参数
 *
 * 重要：
 *     JDK动态代理强制要求目标对象必须有接口，代理的也是接口中的方法
 *     如果目标对象没有接口，会报错！！！
 */
public class DynamicProxy {

    public static Object getProxyInstance(Object target) {
        Object proxyInstance = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 添加日志
                        LogUtil.start(method.getName(),  args);
                        Object result = null;
                        try {
                            result = method.invoke(target, args);
                            LogUtil.end(method.getName(), result);
                        } catch (Exception e) {
                            LogUtil.error(method.getName(), e.getCause());
                            throw new RuntimeException(e);
                        }
                        return result;
                    }
                }
        );
        return proxyInstance;
    }
}
