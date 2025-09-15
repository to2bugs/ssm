package com.otto.spring.config;

import com.otto.spring.datasource.MyDatasource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 1，自定义环境标识: dev、prod、test
 * 2，激活环境标识:
 *      明确告诉Spring当前处于什么环境
 *      如果没有明确什么环境，默认是default环境哦
 */
@Configuration
public class DataSourceConfiguration {

    // 利用条件注解，只在开发环境下激活devDatasource组件放入IOC容器
    @Profile({"dev", "default"}) // @Profile("环境标识") 环境标识可以自己定义哦
    @Bean
    public MyDatasource devDataSource() {
        MyDatasource datasource = new MyDatasource();
        datasource.setUrl("jdbc:mysql://localhost:3306/dev");
        datasource.setUsername("root");
        datasource.setPassword("1234");
        datasource.setType("DuridDataSource");
        return datasource;
    }

    // 利用条件注解，只在生产环境下激活prodDatasource组件放入IOC容器
    @Profile("prod") // @Profile("环境标识")
    @Bean
    public MyDatasource prodDataSource() {
        MyDatasource datasource = new MyDatasource();
        datasource.setUrl("jdbc:mysql://47.101.56.201:3306/prod");
        datasource.setUsername("root");
        datasource.setPassword("123456");
        datasource.setType("DuridDataSource");
        return datasource;
    }

    // 利用条件注解，只在测试环境下激活testDatasource组件放入IOC容器
    @Profile("test") // @Profile("环境标识")
    @Bean
    public MyDatasource testDataSource() {
        MyDatasource datasource = new MyDatasource();
        datasource.setUrl("jdbc:mysql://localhost:3306/test");
        datasource.setUsername("root");
        datasource.setPassword("123456");
        datasource.setType("DuridDataSource");
        return datasource;
    }
}
