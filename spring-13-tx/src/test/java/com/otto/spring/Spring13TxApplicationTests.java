package com.otto.spring;
import java.math.BigDecimal;

import com.otto.spring.bean.Book;
import com.otto.spring.dao.AccountDao;
import com.otto.spring.dao.BookDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Spring13TxApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;

    @Test
    void testDataSource() throws SQLException {
        Assertions.assertNotNull(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 测试根据id查询图书
     */
    @Test
    void testGetBookById() throws SQLException {
        Book book = bookDao.getBookById(1);
        System.out.println(book);
    }

    /**
     * 添加图书
     */
    @Test
    void testAddBook() throws SQLException {
        Book book = new Book();
        book.setBookName("西游记");
        book.setPrice(new BigDecimal("19.9"));
        book.setStock(100);
        bookDao.addBook(book);
    }

    /**
     * 根据id修改图书的库存
     */
    @Test
    void testUpdateBookStockById() throws SQLException {
        bookDao.updateBookStockById(4,1);
    }

    /**
     * 根据id删除用户
     */
    @Test
    void testDeleteBookById() throws SQLException {
        bookDao.deleteBookById(4);
    }


    /**
     * 按照username扣减账户余额
     */
    @Test
    void testSubAccountByUsername() throws SQLException {
        accountDao.updateAccountByUsername("王五", new BigDecimal("19.9"));
    }
}
