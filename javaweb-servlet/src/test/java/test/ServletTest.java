package test;

import com.example.servlet.HelloServlet;
import com.example.servlet2.Customer;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.junit.Test;

public class ServletTest {


    @Test
    public void helloServlet() {
        HelloServlet helloServlet = new HelloServlet();
//        helloServlet.service();
    }
}
