package com.otto.spring.dao;

import com.otto.spring.datasource.MyDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryDao {

    // 精确指定要自动装配的bean
    // @Qualifier(value = "prodDataSource")
    // @Autowired
    // MyDatasource dataSource;

    // 利用条件注解，在某种环境下，比如生成环境、开发环境、测试环境，只激活一个MyDatasource类型的组件
    @Autowired
    MyDatasource dataSource;

    void saveDelivery() {
        System.out.println("数据源：" + dataSource + "正在保存数据!");
    }
}
