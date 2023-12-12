package gov.example.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler {

    Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object retValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("time used: " + (end - start) + "ms");
        return null;
    }
}
