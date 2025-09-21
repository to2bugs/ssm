package com.otto.mybatis.config;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MyBatisConfig {

    @Bean
    public PageInterceptor pageInterceptor() {
        // 1, 创建分页插件的对象
        PageInterceptor pageInterceptor = new PageInterceptor();
        // 2, 设置参数
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true"); // 页码小于0时，显示第一页；页码不合理的大时，显示最后一页
        pageInterceptor.setProperties(properties);
        // 3. 返回
        return pageInterceptor;
    }
}
