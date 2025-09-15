package com.otto.spring12aopround;

import com.otto.spring12aopround.calc.MathCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring12AopRoundApplicationTests {

    @Autowired
    MathCalculator mathCalculator;

    @Test
    void testArround() {
        mathCalculator.div(10, 2);
    }

}
