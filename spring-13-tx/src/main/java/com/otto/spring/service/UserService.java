package com.otto.spring.service;


import com.otto.spring.bean.Account;

public interface UserService {
    /**
     *
     * @param account 用户名
     * @param bookId 图书id
     * @param count 购买数量
     */
    void checkout(String username, Integer bookId, Integer count);
}
