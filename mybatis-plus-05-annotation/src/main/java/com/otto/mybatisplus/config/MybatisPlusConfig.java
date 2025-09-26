package com.otto.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.otto.mybatisplus.mapper")
@Configuration
public class MybatisPlusConfig {

    // 添加 MyBatis-Plus的插件，分页拦截器
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // MybatisPlusInterceptor 可以理解为是 mybatis-plus 的插件集合，只需要将 mybatis-plus 的插件添加到集合中即可
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件，并指定数据库的类型
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 添加乐观锁(版本号插件)，MybatisPlus会在更新时，帮我们对比版本号字段和版本号字段的值+1
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 防全表的更新和删除的实现，即防止删库跑路
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }
}
