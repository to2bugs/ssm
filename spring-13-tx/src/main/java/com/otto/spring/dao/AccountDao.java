package com.otto.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.SQLException;

@Component
public class AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 按照username扣减账户余额
     */
    public void updateAccountByUsername(String username, BigDecimal delta)  {
        String sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, delta, username);
    }
}
