package com.otto.mybatisplus;

import com.otto.mybatisplus.mapper.UserMapper;
import com.otto.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusVersionTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User u1 = userMapper.selectById(5); // 获得乐观锁的版本号 = 1
        User u2 = userMapper.selectById(5); // 获得乐观锁的版本号 = 1

        u1.setAge(20);
        u2.setAge(30);

        userMapper.updateById(u1); // age = 20, 并且 version++ == 2
        userMapper.updateById(u2); // 乐观锁生效，更新失败，因为乐观锁的版本号为1，而不是2
    }
}
