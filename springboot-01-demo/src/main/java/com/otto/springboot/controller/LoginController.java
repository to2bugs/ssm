package com.otto.springboot.controller;

import com.otto.springboot.event.UserLoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    // 注入一个事件发布器
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/login")
    public String login(String username, String password) {
        log.info("{} 登陆成功", username);

        // 发布用户登陆成功事件
        publisher.publishEvent(new UserLoginSuccessEvent(username));


        return "login success!!!";
    }
}
