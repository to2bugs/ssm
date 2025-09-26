package com.otto.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.otto.mybatisplus.pojo.User;

/**
 * IService<T> 只提供了一半的方法，有些方法是在类 ServiceImpl<T, D>中提供了实现
 */
public interface UserService extends IService<User> {
}
