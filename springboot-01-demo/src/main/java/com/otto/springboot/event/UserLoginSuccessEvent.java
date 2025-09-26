package com.otto.springboot.event;

import lombok.Data;

/**
 * 定义事件，用户登陆成功的事件
 */
@Data
public class UserLoginSuccessEvent {
    private String username;

    public UserLoginSuccessEvent(String username) {
        this.username = username;
    }
}
