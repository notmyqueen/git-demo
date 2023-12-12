package gov.example.proxy.client;

import gov.example.proxy.service.OrderService;
import gov.example.proxy.service.OrderServiceImpl;
import gov.example.proxy.service.TimeInvocationHandler;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        /*
            1. newProxyInstance: 新建代理对象
                也就是说，通过调用这个方法可以创建代理对象。
                本质上，这个Proxy.newProxyInstance()方法的执行，做了两件事：
                    第一件事：在内存中动态的生成了一个代理类的字节码class。
                    第二件事：new对象了。通过内存中生成的代理类这个代码，实例化了代理对象。
         */
        OrderService proxyObj = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimeInvocationHandler(target));

        proxyObj.generate();
        proxyObj.modify();
        proxyObj.detail();
    }
}
