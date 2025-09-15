package com.otto.spring.config;

import com.otto.spring.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UserConfiguration {

    @Bean
    public User williamHenryGates() {
        User user = new User();
        user.setName("比尔盖茨");
        user.setAge(80);
        user.setGender("男");

        return user;
    }

    /**
     *
     * @Primary 指定默认自动装配的实例
     */
    @Primary
    @Bean
    public User stevenPaulJobs() {
        User user = new User();
        user.setName("史蒂夫・保罗・乔布斯");
        user.setAge(100);
        user.setGender("男");

        return user;
    }
}
