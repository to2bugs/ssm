package com.otto.springboot.service;

import com.otto.springboot.event.UserLoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 用户登陆后就给用户积分
 */
@Slf4j
@Service
public class UserPointsService {

    // 定义一个事件监听器
    // 使用注解@EventListener，并指定监听哪个类型的事件
    // 使用注解@Async实现异步监听，前提是在配置类上，这里是在启动类上，使用@EnableAsync开启基于注解的异步操作
    @Async
    @EventListener(UserLoginSuccessEvent.class)
    public void listener(UserLoginSuccessEvent event) {
        log.info("监听到{}事件", event.getClass());
        // 监听到事件后的后续actions
        String username = event.getUsername();
        givePoints(username);
    }

    public void givePoints(String username) {
        log.info("yh: {} 获得积分", username);
    }
}
