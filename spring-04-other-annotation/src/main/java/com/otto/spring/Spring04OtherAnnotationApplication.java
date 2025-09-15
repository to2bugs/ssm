package com.otto.spring;

import com.otto.spring.bean.Car;
import com.otto.spring.bean.Dog;
import com.otto.spring.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@SpringBootApplication
public class Spring04OtherAnnotationApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc = SpringApplication.run(Spring04OtherAnnotationApplication.class, args);

        System.out.println("========== 单实例模式 ==========");

        Person lisi1 = ioc.getBean("lisi", Person.class);
        Map<String, Person> map = ioc.getBeansOfType(Person.class);
        map.forEach((k, v) -> {
            if (v == lisi1) {
                System.out.println("~~~~单实例哦~~~~");
            }
        });

        System.out.println("========== 懒加载配合单例模式 ==========");

        System.out.println("========== FactoryBean制造对象，并添加注册到容器中 ==========");

        Car car = ioc.getBean(Car.class);
        System.out.println(car); // 单例的

        Map<String, Car> beansOfType = ioc.getBeansOfType(Car.class);
        System.out.println(beansOfType); // bean的名称是BYDFactory


        System.out.println("========== 条件注入组件 ==========");

        // 获取环境变量
        ConfigurableEnvironment environment = ioc.getEnvironment();
        String os = environment.getProperty("OS");
        System.out.println("os = " + os);

        Map<String, Person> map1 = ioc.getBeansOfType(Person.class);
        System.out.println(map1);

        Map<String, Dog> dogMap = ioc.getBeansOfType(Dog.class);
        System.out.println(dogMap);
    }

}
