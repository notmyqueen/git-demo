import com.example.service.FireService;
import com.example.service.MatrixFireService;
import com.example.service.config.Spring6Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    //全注解开发
    @Test
    public void testAllAnnotation() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        FireService fireService = applicationContext.getBean("fireService", FireService.class);
        MatrixFireService matrixFireService = applicationContext.getBean("matrixFireService", MatrixFireService.class);
        fireService.fire();
        matrixFireService.matrixFire();
    }

    @Test
    public void testAop() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aspect.xml");
        FireService fireService = applicationContext.getBean("fireService", FireService.class);
        MatrixFireService matrixFireService = applicationContext.getBean("matrixFireService", MatrixFireService.class);
        fireService.fire();
        matrixFireService.matrixFire();
    }
}
