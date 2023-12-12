package com.example.proxy.client;

import com.example.proxy.service.OrderService;
import com.example.proxy.service.OrderServiceImpl;
import com.example.proxy.service.TimerInvocationHandler;
import review.reflect.User;

import java.lang.reflect.Proxy;

public class ClientTest {
    public static void main(String[] args) throws ClassNotFoundException {

        //比如这个Spring里动态代理的代码，target.getClass().getClassLoader()和随便new的一个对象的ClassLoader是同一个，那为什么Proxy.newProxyInstance参数里还要指定是target？
        OrderService target = new OrderServiceImpl();

        OrderService proxyObj = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target));

        proxyObj.generate();

        User user = new User();
        System.out.println(target.getClass().getClassLoader() == user.getClass().getClassLoader()); //true

        //就是获取当前这个类的AppClassLoader，即系统加载类。和这个类里的别的类的系统加载类是同一个！
        ClassLoader.getSystemClassLoader();  //jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b

        //获取当前这个类的扩展类加载器，JDK9之后更名为平台类加载器(platform class loader)，一个概念。
        //目前看，暂时用不到，没什么意义
        ClassLoader.getPlatformClassLoader(); //jdk.internal.loader.ClassLoaders$PlatformClassLoader@cc34f4d

        ClassLoader classLoader2 = ClassLoader.getPlatformClassLoader().getClass().getClassLoader();
        System.out.println(classLoader2);

        System.out.println(target.getClass());
        System.out.println(OrderServiceImpl.class);

        Class<? super User> superclass = User.class.getSuperclass();
        System.out.println(superclass);

        String typeName = User.class.getTypeName();
        System.out.println(typeName);

        System.out.println(User.class.getClass());
        System.out.println(new User().getClass());

        System.out.println(User.class);
        Class<User> userClass = User.class;

        //方法1：
        System.out.println(User.class.getClassLoader()); //jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b。自己写的类的类加载器是AppClassLoader。
        System.out.println(String.class.getClassLoader()); //null。为什么？因为这些java.lang里的类是由BootStrap loader加载的，是C/C++写的，在jvm里是null。

        //方法2：
        Class<?> aClass2 = Class.forName("review.reflect.User");
        System.out.println(aClass2.getClassLoader()); //jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b

        //方法3：
        User user1 = new User();
        ClassLoader classLoader3 = user1.getClass().getClassLoader();
        System.out.println(classLoader3);  //jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b


        System.out.println("--------------------");


        Class<? extends Class> aClass = ClientTest.class.getClass();
        System.out.println(aClass);

        ClassLoader classLoader = ClientTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);

        String s = "123";
        ClassLoader classLoader1 = s.getClass().getClassLoader();
        Class<? extends String> aClass1 = s.getClass();
        System.out.println(aClass1);
        System.out.println(classLoader1);
    }
}
