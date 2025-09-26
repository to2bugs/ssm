package com.otto.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.otto.mybatisplus.mapper.UserMapper;
import com.otto.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusQueryWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test_01() {
        // 查询用户名包含a，年龄在20到30岁之间，并且邮箱不为null的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test_02() {
        // 按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .orderByDesc("age")
                .orderByAsc("id");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test_03() {
        // 删除email为null的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");

        userMapper.delete(queryWrapper);
    }

    @Test
    void test_04() {
        // 将年龄大于20并且用户名中包含o或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .gt("age", 20)
                .like("name", "o") // 条件直接调用方法默认使用and拼接
                .or()
                .isNull("email");

        // 要修改的数据
        User user = new User();
        user.setEmail("XXX@hotmail.com");

        userMapper.update(user, queryWrapper);
    }

    @Test
    void test_05() {
        // 指定列的映射，默认是查询全部列
        // 查询用户的name和age
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("id", "name", "age", "email")
                        .gt("id", 1);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * QueryWarpper 每一个方法都有一个condition条件，允许在参数的第一个位置放一个比较表达式
     *      当此比较表达式为true时，整个条件生效，反之
     *      相当于一个动态的SQL
     */
    @Test
    void test_06() {
        // 前端传入两个参数：name 和 age
        String name = "xxx";
        Integer age = 20;
        // 在name不等于null时，查询name中包含o的用户
        // 在age > 18 时，查询age等于45的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like(name != null, "name", "o")
                .eq(age != null && age > 18, "age", 45);

        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }
}
