import com.example.spring6.bean.Dagger;
import com.example.spring6.bean.Star;
import com.example.spring6.bean.StarFactory;
import com.example.spring6.bean.Tank;
import com.example.spring6.bean2.Student;
import com.example.spring6.bean2.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationTest {

    @Test
    public void testRegisterBean() {
        //自己new的对象
        Student stu = new Student();
        System.out.println(stu);

        //将以上自己new的对象纳入Spring容器来管理。半路上交给Spring来管理。
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean", stu);

        //从spring容器中获取
        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);
    }

    @Test
    public void testBeanLifecycleFive() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("lifecycle.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第六步：使用Bean：" + user);
        //注意：必须手动关闭Spring容器，这样Spring容器才会销毁Bean
        //需要向下转型一下
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testBeanFacJiekou() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Tank tank = applicationContext.getBean("tank", Tank.class);
        System.out.println(tank);
    }

    @Test
    public void testBeanFac() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Dagger dagger = applicationContext.getBean("dagger", Dagger.class);
        System.out.println(dagger);
    }

    @Test
    public void testBeanFactoryGet() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star star = applicationContext.getBean("sfBean", Star.class);
        System.out.println(star);
    }
}
