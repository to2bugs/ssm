package com.otto.spring.factory;

import com.otto.spring.bean.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * FactoryBean<T> 其中的泛型T表示bean工厂是要造什么类型的Bean实例
 * 注意组件bean在IOC容器中的名字是BYDFactory，而组件bean的类型是泛型的类型，即com.otto.spring.bean.Car
 * 场景：如果制造某些对象比较的麻烦，你用工厂方法
 */
@Component
public class BYDFactory implements FactoryBean<Car> {
    /**
     * 调用此方法，制造对象并添加到IOC容器
     *
     */
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setType("han");
        car.setCarName("汗EV");

        return car;
    }

    /**
     * 说明造的东西的类型
     *
     */
    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    /**
     * 是单例模式吗？？？
     * 返回true，单例模式
     * 返回false，非单例模式
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
