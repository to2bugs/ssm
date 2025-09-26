package com.otto.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.otto.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 自定义一个根据年龄参数查询，并分页的方法
    IPage<User> queryUserPageByAge(IPage<User> page, @Param("age") Integer age);
}
