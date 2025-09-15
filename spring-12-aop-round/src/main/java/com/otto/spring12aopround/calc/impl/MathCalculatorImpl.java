package com.otto.spring12aopround.calc.impl;

import com.otto.spring12aopround.calc.MathCalculator;
import org.springframework.stereotype.Service;

@Service
public class MathCalculatorImpl implements MathCalculator {
    @Override
    public Integer add(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    public Integer sub(Integer num1, Integer num2) {
        return num1 - num2;
    }

    @Override
    public Integer mul(Integer num1, Integer num2) {
        return num1 * num2;
    }

    @Override
    public Integer div(Integer num1, Integer num2) {
        return num1 / num2;
    }
}
