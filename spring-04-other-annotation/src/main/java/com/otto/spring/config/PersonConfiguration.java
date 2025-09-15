package com.otto.spring.config;

import com.otto.spring.bean.Person;
import com.otto.spring.condition.MacOSCondition;
import com.otto.spring.condition.WindowsCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 条件注解@Conditional(value = 条件) 既可以注解在类上，也可以注解在类的方法上
 *     判断条件是否成立，即条件返回的值如果是true，则PersonConfiguration中的所有Bean组件会被注入IOC容器，否则反之
 */
// @Conditional(MacOSCondition.class)
@ConditionalOnProperty("OS") // 配置文件or环境变量中是否有key的名称为OS时，才会注入当前类中的所有组件
@Configuration
public class PersonConfiguration {
    /**
     * @Scope 调整组件的作用域
     * 1. @Scope("singleton") 组件是单例模式 默认
     *      单例模式时，组件的创建即构造器的调用是在IOC容器创建之后自动调用的
     * 2. @Scope("prototype") 组件是非单例模式
     *      非单例模式时，组件的创建即构造器的调用是在组件被获取时才调用的，每次获取都会创建一个新的组件实例，也即容器启动时不会创建非单例组件对象
     * 3. @Scope("request") 组件在同一个请求时是单例模式
     * 4. @Scope("session") 组件在同一个session会话时是单例模式
     */
    @Bean(name = "lisi")
    public Person lisi() {
        Person person = new Person();
        person.setName("李四");
        person.setAge(50);
        person.setGender("男");
        return person;

    }

    @Bean(name = "wangwu")
    public Person wangwu() {
        Person person = new Person();
        person.setName("王五");
        person.setAge(10);
        person.setGender("女");
        return person;
    }

    /*
      场景：
           判断当前电脑的操作系统是Windows还是MacOs
           Windows系统时，IOC容器中放入比尔盖茨
           MacOs系统时，IOC容器中放入史蒂夫・保罗・乔布斯
     */
    @Conditional(WindowsCondition.class)
    @Bean(name = "bill-gates")
    public Person billGates() {
        Person person = new Person();
        person.setName("比尔盖茨");
        person.setAge(80);
        person.setGender("男");
        return person;
    }

    @Conditional(MacOSCondition.class)
    @Bean(name = "Steven-Paul-Jobs")
    public Person stevenPaulJobs() {
        Person person = new Person();
        person.setName("史蒂夫・保罗・乔布斯");
        person.setAge(120);
        person.setGender("男");
        return person;
    }
}
