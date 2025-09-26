package com.otto.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otto.mybatisplus.mapper.UserMapper;
import com.otto.mybatisplus.pojo.User;
import com.otto.mybatisplus.service.UserService;

public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {
}
