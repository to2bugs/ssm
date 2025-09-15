package com.otto.spring;

import com.otto.spring.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class Spring14TxIsolationApplicationTests {

    @Autowired
    BookDao bookDao;

    @Test
    void contextLoads() {

    }

}
