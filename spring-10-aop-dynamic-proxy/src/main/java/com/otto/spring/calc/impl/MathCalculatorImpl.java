package com.otto.spring.calc.impl;

import com.otto.spring.calc.MathCalculator;
import org.springframework.stereotype.Component;

/**
 * 添加日志：
 * 1，硬编码: 不推荐，耦合高
 * 2，静态代理
 *      定义: 定义一个代理对象来包装组件。以后业务的执行，从代理开始而不直接调用组件
 *      特点: 定义期间就指定好了代理关系哦
 * 3，动态代理
 *      定义: 目标对象在执行期间会被动态代理，插入指定的逻辑，拦截器的思想
 *      特点: 可以代理任何对象，且Java原生支持
 *
 */
@Component
public class MathCalculatorImpl implements MathCalculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
