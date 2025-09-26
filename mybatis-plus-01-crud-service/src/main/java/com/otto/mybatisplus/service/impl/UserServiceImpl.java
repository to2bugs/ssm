package com.otto.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.otto.mybatisplus.mapper.UserMapper;
import com.otto.mybatisplus.pojo.User;
import com.otto.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ServiceImpl<D, T> 是接口 IService<T> 的实现类
 * ServiceImpl的泛型 T 是要操作的哪个实体类Bean，而泛型 D 是泛型 T 使用的Mapper
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
