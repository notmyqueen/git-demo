package testJDBC;

import com.oa.utils.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBC {
    @Test
    public void test() {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }
}
