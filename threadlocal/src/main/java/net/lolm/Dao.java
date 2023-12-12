package net.lolm;

public class Dao {
    public void insert() {

        Connection connection = DBUtil.getConnection();
        System.out.println("Dao里的conn：" + connection);
        System.out.println("Dao的insert方法执行");
    }
}
