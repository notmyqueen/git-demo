package org.icbc.service;

import jakarta.annotation.Resource;
import org.icbc.dao.ICBCAccountDao;
import org.icbc.pojo.BankAccount;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("iCBCServiceDaoImpl")
@Transactional //写在类上，表示这个这整个类都用事物控制。（写在方法上，表示只在这个方法上使用事务控制）
public class ICBCServiceDaoImpl implements ICBCServiceDao {
    @Resource
    JdbcTemplate jdbcTemplate;

    //Service层调用Dao层来完成业务。所以Dao层的接口要引入。依据Dao这个实体类的方法来进行业务（即此例中的增删改查方法的执行）
    @Resource
    private ICBCAccountDao icbcAccountDao;

    @Override
    public int add(String actno, Double initialBalance) {
        return icbcAccountDao.add(actno, initialBalance);
    }

    @Override
    public int delete(String actno) {
        return icbcAccountDao.delete(actno);
    }

    @Override
    public int update(String actno, Double balance) {
        return icbcAccountDao.update(actno, balance);
    }

    @Override
    public BankAccount selectActByActno(String actno) {
        BankAccount ba = icbcAccountDao.selectAccountByActNo(actno);
        return ba;
    }

    @Override
    public int[] batchAdd(List<Object[]> list) {
        return icbcAccountDao.batchAdd(list);
    }

    @Override
    public void transfer(String fromActno, String toActno, Double amount) {
        //查询转出账户的余额够不够
        BankAccount fromAct = icbcAccountDao.selectAccountByActNo(fromActno);
        BankAccount toAct = icbcAccountDao.selectAccountByActNo(toActno);
        if (fromAct.getBalance() < amount) {
            throw new RuntimeException(fromAct.getActno() + "余额不足");
        }

        //余额充足，就转账
        //1、扣钱
        double balanceAfterTransferOfFromAccount = fromAct.getBalance() - amount;
        int count = icbcAccountDao.update(fromActno, balanceAfterTransferOfFromAccount);
        //2、加钱
        double balanceAfterTransferOfToAccount = toAct.getBalance() + amount;
        //模拟异常
//        String s = null;
//        s.toString();

        count += icbcAccountDao.update(toActno, balanceAfterTransferOfToAccount);


        if(count!=2) {
            throw new RuntimeException("转账失败，联系银行");
        } else {
            System.out.println("转账成功！");
        }

        //重新获取Conn，再输出转账后的账户余额。不重新获取的话就是初始化时的账户余额，即转帐前的账户余额。
        String sql= "select actno, balance from spring_bank where actno=?";
        BankAccount bankAccount = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BankAccount.class), "act-001");
        System.out.println("转出账户：" + bankAccount.getActno() + " " + "余额：" + bankAccount.getBalance());

        String sql2= "select actno, balance from spring_bank where actno=?";
        BankAccount bankAccount2 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BankAccount.class), "act-002");
        System.out.println("转入账户：" + bankAccount2.getActno() + " " + "余额：" + bankAccount2.getBalance());

//        System.out.println("转出账户：" + fromAct.getActno() + " " + "余额：" + fromAct.getBalance());
//        System.out.println("转入账户：" + toAct.getActno() + " " + "余额：" + toAct.getBalance());
    }


    @Resource(name="service2")
    private ICBCServiceDao icbcServiceDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(BankAccount act) {
        BankAccount account = new BankAccount("act-004", 1000.0);
        icbcServiceDao.save(account);

    }
}
