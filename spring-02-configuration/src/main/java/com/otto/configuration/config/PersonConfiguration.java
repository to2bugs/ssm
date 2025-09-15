package com.otto.configuration.config;

import com.otto.configuration.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类也是一个组件
 */
@Configuration
public class PersonConfiguration {

    @Bean(name = "zhangsan")
    public Person person1() {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(20);
        p1.setGender("男");

        return p1;
    }

    @Bean(name = "lisi")
    public Person person2() {
        Person p1 = new Person();
        p1.setName("李四");
        p1.setAge(10);
        p1.setGender("男");

        return p1;
    }
}
