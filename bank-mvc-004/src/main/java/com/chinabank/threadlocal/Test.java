package com.chinabank.threadlocal;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        //设置当前线程的优先级，并输出
        Thread.currentThread().setPriority(4);
        System.out.println(Thread.currentThread());

        //引入ThreadLocal的本质是，利用Util的getConnection方法将唯一的connection带入到每个dao方法里，使所有的dao方法都共享一个connection。
        UserService service = new UserService();
        service.transfer();
    }
}
