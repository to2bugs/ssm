package com.otto.spring.proxy.statics;

import com.otto.spring.calc.MathCalculator;
import org.springframework.stereotype.Component;

/**
 * 静态代理:
 *      定义代理对象和目标对象都是同一个接口的子类型：implements MathCalculator
 *      代理对象将目标对象作为自己的属性：private MathCalculator mathCalculator
 *      定义期间就指定好了代理关系，在编码的时候就确认了代理关系
 *
 *      优点：同一种类型的所有对象都能代理
 *      缺点：只能代理同一个接口的子类
 */
@Component
public class CalculatorStaticProxy implements MathCalculator {

    // 定义代理的目标对象
    private MathCalculator mathCalculator;

    public CalculatorStaticProxy(MathCalculator mathCalculatorImpl) {
        this.mathCalculator = mathCalculatorImpl;
    }

    @Override
    public int add(int i, int j) {
        int result = this.mathCalculator.add(i, j);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = this.mathCalculator.sub(i, j);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = this.mathCalculator.mul(i, j);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = this.div(i, j);
        return result;
    }
}
