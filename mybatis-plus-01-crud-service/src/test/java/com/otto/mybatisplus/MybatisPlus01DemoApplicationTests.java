package com.otto.mybatisplus;

import com.otto.mybatisplus.mapper.UserMapper;
import com.otto.mybatisplus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@SpringBootTest
class MybatisPlus01DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setName("MMM");
        user.setAge(18);
        user.setEmail("mmm@email.com");
        // BaseMapper提供的数据库插入方法
        int row = userMapper.insert(user);
        log.info("影响的行数:{}", row);
    }

    @Test
    void testDelete() {
        // 根据id删除
        Long id = 1970458698905296897L;
        int rows = userMapper.deleteById(id);
        log.info("根据id: {} 删除，影响 {} 行数据", id, rows);
        // 根据 age=20 删除
        HashMap<String, Object> map = new HashMap<>();
        map.put("age",88);
        rows = userMapper.deleteByMap(map);
        log.info("删除年龄 = {} 的数据，影响 {} 行数据", map.get("age"), rows);
        // Wrapper 条件封装对象，可以无限的封装对象
        // userMapper.delete(wrapper);
    }

    // 当属性值为null时，不修改!!!
    @Test
    void testUpdate() {
        // 必须设置id值
        Long id = 1970459593336434689L;
        User user = new User();
        user.setId(id);
        user.setName("otto");
        user.setAge(50);
        user.setEmail("totobage@email.com");

        int rows = userMapper.updateById(user);
        log.info("修改用户，影响的行数是: {}条", rows);

        // 将所有用户的年龄修改为22
        // 可以不设置id值
        User u1 = new User();
        u1.setAge(22);

        int rows1 = userMapper.update(u1, null); // null 代表没有条件的修改
        log.info("将所有用户的年龄修改为22，影响的行数是: {}条", rows1);
    }

    @Test
    void testSelect() {
        User user1 = userMapper.selectById(1L);
        //
        ArrayList<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        List<User> users = userMapper.selectByIds(ids);
        users.forEach(System.out::println);
        //
        HashMap<String, Object> queryMap = new HashMap<>();
        List<User> users1 = userMapper.selectByMap(queryMap);
    }
}
