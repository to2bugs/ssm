package com.otto.spring.controller;

import com.otto.spring.bean.Car;
import com.otto.spring.bean.Dog;
import com.otto.spring.bean.User;
import com.otto.spring.dao.UserDao;
import com.otto.spring.service.UserService;
import jakarta.annotation.Resource;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * @Autowired 注入，自动装配
 */
@ToString
@Controller
public class UserController {

    /**
     * 自动装配的流程：
     *  1，先按照类型UserService.class从容器中找组件
     *        如果只有一个组件，则自动的注入，比如注入给变量abc，对变量名没有任何的要求
     *        如果有多个同类型的组件，会根据变量名stevenPaulJobs作为组件的名字在ioc容器中找；如果找不到则会报错哦
     *  2，
     */
    @Autowired
    UserService abc;

    @Autowired
    // User user; // 这样写会报错：Could not autowire. There is more than one bean of 'User' type.
    User stevenPaulJobs; // 变量名必须写组件的名称

    @Autowired
    User[] users;

    // 这样写可以将容器中所有的User.class类型的组件，装配到List中
    @Autowired
    List<User> userList;

    // 这样写可以将容器中所有的User.class类型的组件，装配到Map中，其中将组件的名字作为key
    @Autowired
    Map<String, User> userMap;

    // 注入ioc容器
    @Autowired
    ApplicationContext applicationContext;

    /**
     * @Qualifier 注解用于解决依赖注入时的歧义性
     * 当容器中存在多个同类型的 Bean 时，通过该注解指定具体要注入的 Bean 名称，明确告诉 Spring 应该选择哪个实例。
     * 比如这里要求明确注入Bean的名称为williamHenryGates的组件给user变量
     */
    @Autowired
    @Qualifier(value = "williamHenryGates")
    User user;


    /**
     * @Resource javaEE提供的自动注入注解，具有更强的通用性
     *  相当于@Resource是接口，@Autowired是实现类
     */
    @Resource
    UserDao userDao;


    // private final Dog dog;
    private Car car;

    /**
     * 构造器注入
     *  Spring自动去容器中找到构造器需要的所有参数的组件
     *  Spring推荐使用哦！！！
     */
    // public UserController(Dog dog) {
    //     System.out.println("~~~~~~~ UserController的有参构造器的dog ~~~~~~~" + dog);
    //     this.dog = dog;
    // }


    /**
     * setter注入
     */
    @Autowired
    public void setCar(@Qualifier("car02") Car car) {
        System.out.println("setter注入的car: " + car);
        this.car = car;
    }
}
