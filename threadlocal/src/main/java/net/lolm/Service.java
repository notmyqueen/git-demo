package net.lolm;

public class Service {
    private Dao dao = new Dao();
    public void save() {

        Connection connection = DBUtil.getConnection();
        System.out.println("Service里的conn：" + connection);

        dao.insert();
        System.out.println("Service的save方法执行！");
    }
}
