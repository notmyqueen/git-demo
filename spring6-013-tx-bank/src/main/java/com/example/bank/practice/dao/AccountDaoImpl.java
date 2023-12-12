package com.example.bank.practice.dao;

import com.example.bank.practice.pojo.BankAccount;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addAccount(String actno, Double balance) {

        BankAccount bankAccount = new BankAccount(actno, balance);

        //增加账号的SQL语句
        String sql = "INSERT INTO spring_bank (actno, balance) VALUES (?, ?)";
        int count = jdbcTemplate.update(sql, bankAccount.getActno(), bankAccount.getBalance());
        System.out.println("新增账户信息：" + bankAccount.toString());
        return count;
    }
}
