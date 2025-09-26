package com.otto.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.otto.mybatisplus.mapper.UserMapper;
import com.otto.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusPageTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testPage() {
        /*
            selectPage
                第一个参数：IPage接口，使用其的实现类Page
         */
        Page<User> page = new Page<>(1, 10);
        userMapper.selectPage(page, null); // 结果会被封装到page中哦‼️
        // 获取结果
        long current = page.getCurrent(); // 页码
        long pageSize = page.getSize(); // 页容量
        page.getRecords().forEach(System.out::println); // 当前页的数据
        long total = page.getTotal(); // 数据的总条数
    }

    // 自定义分页
    // 自定义一个根据年龄参数查询，并分页的方法
    @Test
    void testPage2() {
        Page<User> page = new Page<>(1, 10);
        userMapper.queryUserPageByAge(page, 10);

        page.getRecords().forEach(System.out::println);
    }

}
