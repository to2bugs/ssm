package com.otto.spring.service.impl;

import com.otto.spring.annotation.An;
import com.otto.spring.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 被切面的类在IOC容器中的组件都是代理对象
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {

    }

    @An
    @Override
    public void getUser(int i, int j) {

    }

    @Override
    public void updateUser(An an) {
        System.out.println("更新An");
    }


}
