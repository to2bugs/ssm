package com.otto.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.otto.mybatisplus.mapper.UserMapper;
import com.otto.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusLambdaQueryWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        // 查询用户名包含o，年龄在20到30之间，且邮箱不为null的用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper
                .like(User::getName, "o")
                .between(User::getAge, 10, 20)
                .isNull(User::getEmail);

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
