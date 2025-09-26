package com.otto.springboot;

import com.otto.springboot.bean.Dog;
import com.otto.springboot.properties.DogProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@Slf4j
@SpringBootTest
class Springboot01DemoApplicationTests {
    // 获取到日志记录器
    // Logger logger = LoggerFactory.getLogger(Springboot01DemoApplicationTests.class);

    @Autowired
    DogProperties dogProperties;
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        System.out.println(dogProperties);
        //
        Dog dog = applicationContext.getBean("dog", Dog.class);
        System.out.println("dog = " + dog);
    }

    @Test
    void testLogger() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }

}
