package com.chink.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal {
    private Map<Thread, Object> map = new HashMap<>();

    //向ThreadLocal中绑定数据
    public void set(Object obj) {
        map.put(Thread.currentThread(), obj);
    }

    //获取数据
    public Object get() {
        return map.get(Thread.currentThread());
    }

    //移除数据
    public void remove() {
        map.remove(Thread.currentThread());
    }
}
