package com.otto.spring.config;

import com.otto.spring.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    /**
     * 创建组件 --> 组件构造器 --> @Autowired属性注入 --> postConstruct --> InitializingBean的afterPropertiesSet --> @Bean指定的initMethod --> ... --> destroy --> DestroyBean的destory --> @Bean指定的destroyMethod --> 容器销毁
     *
     */
    @Bean(initMethod = "initUser", destroyMethod = "destroyUser")
    public User wangwu() {
        User user = new User();
        user.setUsername("王五");
        user.setPassword("1234");
        return user;
    }

}
