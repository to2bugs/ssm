package com.otto.spring;

import com.otto.spring.bean.Book;
import com.otto.spring.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    BookDao bookDao;

    @Test
    public void testGetBookPriceById() {
        BigDecimal pric = bookDao.getPriceById(1);
        System.out.println(pric);
    }

}
