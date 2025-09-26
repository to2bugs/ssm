package com.otto.mybatisplus;

import com.otto.mybatisplus.pojo.User;
import com.otto.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class CRUDServiceTest {

    @Autowired
    private UserService userService;

    /**
     * 使用了批量插入数据
     */
    @Test
    public void testSave() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("Oo" + i);
            user.setAge((int)Math.round(Math.random() * 73 + 1));
            user.setEmail("Oo" + i + "@gmail.com");

            users.add(user);
        }
        userService.saveBatch(users);
    }

    /**
     *  如果id不为空，就是修改
     *  如果id为空，就是插入
     */
    @Test
    public void testSaveOrUpdate() {
        // 插入
        User u1 = new User();
        u1.setName("驴蛋蛋01");
        u1.setAge((int)Math.round(Math.random() * 73 + 1));
        u1.setEmail("luedandan01@gamil.com");
        userService.saveOrUpdate(u1);
        // 更新
        User u2 = new User();
        u2.setId(1L);
        u2.setName("驴蛋蛋02");
        u2.setAge((int)Math.round(Math.random() * 73 + 1));
        u2.setEmail("luedandan02@gamil.com");
        userService.saveOrUpdate(u2);
    }

    @Test
    public void testRemove() {
        userService.removeById(1970654253734576129L);
        // 删除名字叫Oo99的用户
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Oo99");
        userService.removeByMap(map);
    }

    @Test
    public void testUpdate() {}

    @Test
    public void testGetOrList() {
        User user = userService.getById(1L);
        userService.list().forEach(System.out::println);
    }
}
