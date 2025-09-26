package com.otto.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.otto.mybatisplus.pojo.User;

/**
 * mapper接口继承自BaseMapper<T>，泛型是要操作的实体类，这里是类User
 */
public interface UserMapper extends BaseMapper<User> {
}
