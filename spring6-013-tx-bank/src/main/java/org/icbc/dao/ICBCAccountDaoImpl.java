package org.icbc.dao;

import org.icbc.pojo.BankAccount;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ICBCAccountDaoImpl implements ICBCAccountDao {
    @Resource(name="jdbcTemplate")  //byName装配JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(String actno, Double initialBalance) {
        //增加account的SQL语句
        String sql="insert into spring_bank (actno, balance) VALUES (?, ?)";

        return jdbcTemplate.update(sql, actno, initialBalance);
    }

    @Override
    public int delete(String actno) {
        //SQL for 删除账号
        String sql = "DELETE from spring_bank WHERE actno = ?";
        return jdbcTemplate.update(sql, actno);
    }

    @Override
    public int update(String actno, Double balance) {
        //SQL for 更新账号(更新的账户余额)
        String sql = "UPDATE spring_bank SET balance = ? WHERE actno = ?";
        return jdbcTemplate.update(sql, balance, actno);
    }

    @Override
    public BankAccount selectAccountByActNo(String actno) {
        //SQL for query
        String sql = "select actno, balance from spring_bank where actno = ?";
        BankAccount bankAccount = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BankAccount.class), actno);
        return bankAccount;
    }

    @Override
    public int[] batchAdd(List<Object[]> list) {
        //SQL for batch add
        String sql = "INSERT INTO spring_bank(actno, balance) VALUES(?,?)";
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        return count;
    }
}
