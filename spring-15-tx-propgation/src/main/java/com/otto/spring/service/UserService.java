package com.otto.spring.service;


public interface UserService {
    /**
     *
     * @param username 用户名
     * @param bookId 图书id
     * @param count 购买数量
     */
    void checkout(String username, Integer bookId, Integer count);
}
