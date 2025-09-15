package com.otto.spring;

import com.otto.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionManager;

@SpringBootTest
public class UserShoppingBookTest {

    @Autowired
    TransactionManager transactionManager;

    @Autowired
    UserService userService;

    /**
     * 用户购买图书结账
     * 谁买了什么书，以及数量是多少
     */
    @Test
    public void testCheckout() {
        userService.checkout("王五", 3, 4);
    }

    /**
     * 查看当前使用的事务
     */
    @Test
    public void testTransaction() {
        System.out.println(transactionManager.getClass());
    }
}
