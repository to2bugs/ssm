package com.otto.spring;

import com.otto.spring.annotation.An;
import com.otto.spring.calc.MathCalculator;
import com.otto.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;

@SpringBootTest
class Spring11AopApplicationTests {
    // 被切入点表达式关联的所有对象，在注入容器时注入的都是代理对象
    @Autowired
    MathCalculator mathCalculator;

    @Autowired
    UserService userService;

    @Test
    void testAspect() {
        System.out.println("定义了切面类后，容器中的组件的类型是代理类型：" + mathCalculator.getClass());
        mathCalculator.mul(23, 45);


        System.out.println("==========  ==========");

        mathCalculator.div(10, 0);
        userService.getUser(12, 34);
        userService.updateUser(new An() {
            @Override
            public String value() {
                return "";
            }

            @Override
            public String toString() {
                return "";
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }
        });
    }

}
