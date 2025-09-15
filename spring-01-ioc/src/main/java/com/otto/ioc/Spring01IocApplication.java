package com.otto.ioc;

import com.otto.ioc.bean.Dog;
import com.otto.ioc.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Map;


@SpringBootApplication
public class Spring01IocApplication {

    /**
     * 组件创建时机：容器启动过程中就会创建组件对象
     * 单实例特性：所有组件默认是单实例的，每次获取时直接从容器中拿。
     *
     */
    public static void main(String[] args) {

        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);

        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        // Arrays.stream(beanDefinitionNames).toList().forEach(System.out::println);

        System.out.println("===== 从容器中获取组件 =====");

        // 从容器中获取指定的组件
        // 组件的四大特性：名字、类型、作用域和对象
        // 1, 从容器中获取组件，如果组件不存在，会抛出 NoSuchBeanDefinitionException 异常
        Person p1 = (Person)ioc.getBean("zhangsan");
        // 2, 从容器中获取组件，如果不唯一，会抛出 NoUniqueBeanDefinitionException 异常
        // Person p2 = ioc.getBean(Person.class);
        // 3, 从容器中获取一堆组件，
        Map<String, Person> map = ioc.getBeansOfType(Person.class);
        System.out.println(map); // {zhangsan=Person(name=张三, age=20, gender=男), lisi=Person(name=李四, age=10, gender=男)}
        // 4, 从容器中获取组件
        Person lisi = ioc.getBean("lisi", Person.class);
        System.out.println(lisi);

        System.out.println("=====容器中组件的单例性=====");

        Dog d1 = ioc.getBean("dog", Dog.class);
        Dog d2 = (Dog)ioc.getBean("dog");
        System.out.println(d1 == d2); // true
    }

    // 注册自定义的组件，放入IOC容器，组件的名字默认是方法名person，这里修改为zhangsan
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

    // 注册自定义的组件
    @Bean
    public Dog dog() {
        Dog dog = new Dog();
        return dog;
    }

}
