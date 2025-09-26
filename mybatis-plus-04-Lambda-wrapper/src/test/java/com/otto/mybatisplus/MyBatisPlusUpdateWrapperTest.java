package com.otto.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.otto.mybatisplus.mapper.UserMapper;
import com.otto.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusUpdateWrapperTest {

    @Autowired
    private UserMapper userMapper;

    /*
        UpdateWrapper
        1. 直接携带修改的值，set("列名", "值")
        2. 可以指定任意修改值为null，这是QueryWrapper在做修改时做不到的，set("列名", null)
     */
    @Test
    public void testUpdateWrapper() {
        // 将年龄大于20并且用户名中包含o或邮箱为null的用户信息修改
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper
                .gt("age", 20)
                .like("name", "O")
                .or()
                .isNull("email")
                .set("name", "ott");
    }
}
