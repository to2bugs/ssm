package com.otto.spring.config;

import com.otto.spring.bean.Dog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class DogConfiguration {

    /**
     * @Lazy 通常是配合单例模式的组件一起使用的，而非单例模式的组件已经是懒加载了
     *      即什么时候获取使用，什么时候创建组件的实例
     */
    @Lazy
    @Scope("singleton")
    @Bean
    public Dog dog() {
        Dog dog = new Dog();
        dog.setName("旺财");
        dog.setAge(0);
        return dog;
    }


    /**
     * @ConditionalOnMissingBean
     * ioc容器中没有名为bill-gates的组件时，则项IOC容器中注入名为saihu的组件
     */
    // ioc容器中“没有”名为bill-gates的组件时，才会向IOC容器中注入名为saihu的组件；
    // 这个理解不全面，是IOC容器中没有名为bill-gates的组件是指没有这个类型的组件，但凡有一个这个类型的组件，都会注入名为saihu的组件
    // 常用于 “默认配置” 场景 —— 当用户未自定义特定 Bean 时，使用框架提供的默认实现；若用户已定义，则优先使用用户的实现。
    @ConditionalOnMissingBean(name = "bill-gates")
    // @ConditionalOnBean(name = "Steven-Paul-Jobs") // IOC容器中“有”名为Steven-Paul-Jobs的组件时，才会向IOC容器中注入名为saihu的组件
    // @ConditionalOnResource(resources = "classpath:haha.abc") // 类路径classpath下是否有指定的资源，如果有则向IOC容器中注入名为saihu的组件
    @Bean
    public Dog saihu() {
        Dog dog = new Dog();
        dog.setName("赛虎");
        dog.setAge(3);
        return dog;
    }
}
