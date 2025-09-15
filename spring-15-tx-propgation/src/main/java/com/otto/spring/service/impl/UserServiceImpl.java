package com.otto.spring.service.impl;

import com.otto.spring.bean.Book;
import com.otto.spring.dao.AccountDao;
import com.otto.spring.dao.BookDao;
import com.otto.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 事务的细节
 *      1.TransactionManager 事务管理器
 *          包含获取事务，以及提交和回滚操作，默认使用org.springframework.jdbc.support.JdbcTransactionManager
 *          TransactionInterceptor 事务拦截器，就是切面类，控制何时提交和回滚
 *      2.propagation 传播行为
 *      3.isolation 隔离级别，解决多个事务读取数据时的脏读、不可重复读、幻读
 *          读未提交：事务可以读到别人没有提交的数据
 *          读已提交：事务只能读已经提交的数据
 *          可重复读：同一事务期间多次重复读取的数据相同
 *          串行化：完全禁止了并发
 *      4.timeout 超时时间，单位是秒
 *          一旦超过约定时间，事务就会回滚
 *          超时时间是指从方法的开始，到最后一次数据库操作结束的时间哦
 *      5.readonly
 *          如果事务中数据库的操作只有读，没有写。则将其赋值为true，可以提高性能
 *      6.rollbackFor / rollbackForClassName
 *          因为什么而回滚，即指定哪些异常需要回滚
 *          并不是所有异常都一定引起事务的回滚
 *              异常分为 运行时异常，又叫UnChecked exception非受检异常，会回滚
 *                      编译时异常，又叫Checked exception受检异常，不会回滚
 *          需要回滚的异常 = 运行时异常 + rollbackFor指定的异常
 *      7.noRollbackFor 指定哪些异常不回滚
 *          需要回滚的异常 = 运行时异常 + rollbackFor指定的异常 - noRollbackFor指定的异常
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;


    @Transactional // 使用Spring提供的事务
    @Override
    public void checkout(String username, Integer bookId, Integer count) {
        // 1, 根据图书id，查询图书信息
        Book book = bookDao.getBookById(bookId);
        // 2, 扣减用户的余额
        accountDao.updateAccountByUsername(username, book.getPrice().multiply(new BigDecimal(count)));
        // 3, 扣减图书的库存
        bookDao.updateBookStockById(bookId, count);

        int i = 10 / 0;
    }


    /**
     * 场景：用户结账炸了以后，金额扣减回滚，但是库存不回滚
     * 实现：
     *      checkout() {
     *          扣减金额 // required
     *          扣减库存 // required_new
     *          int i = 10 / 0 此处造成用户结账checkout炸了
     *      }
     *
     *      checkout是大事务
     */
}
