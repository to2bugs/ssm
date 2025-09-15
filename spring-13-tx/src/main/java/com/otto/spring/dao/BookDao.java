package com.otto.spring.dao;

import com.otto.spring.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


/**
 * jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
 *      new BeanPropertyRowMapper<>(Book.class) 把每行数据封装成Book.clas类型
 *      参数id 传递给 select * from book where id = ? 的 ？
 */
@Component
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 根据id查询图书
     *
     * jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
     *      new BeanPropertyRowMapper<>(Book.class) 把每行数据封装成Book.clas类型
     *      参数id 传递给 select * from book where id = ? 的 ？
     * @param id
     * @return
     */
    public Book getBookById(Integer id) {
        // 定义sql
        String sql = "select * from book where id = ?";
        // 执行查询
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        return book;
    }


    /**
     * 新增图书
     */
    public void addBook(Book book) {
        String sql = "insert into book (bookName, price, stock) values (?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookName(), book.getPrice(), book.getStock());
    }

    /**
     * 根据id修改图书的库存
     * @param id 图书id
     * @Param num 要减少的数量
     */
    public void updateBookStockById(Integer id, Integer num) {
        String sql = "update book set stock = stock - ? where id = ?";
        jdbcTemplate.update(sql, num, id);
    }

    /**
     * 根据id删除用户
     */
    public void deleteBookById(Integer id) {
        String sql = "delete from book where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
