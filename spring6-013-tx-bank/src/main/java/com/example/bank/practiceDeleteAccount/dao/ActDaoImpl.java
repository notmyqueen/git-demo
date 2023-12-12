package com.example.bank.practiceDeleteAccount.dao;

import com.example.bank.practice.pojo.BankAccount;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ActDaoImpl implements ActDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int delete(BankAccount act) {
        //删除账号的SQL
        String sql = "delete from spring_bank where actno = ?";
        return jdbcTemplate.update(sql, act.getActno());
    }
}
