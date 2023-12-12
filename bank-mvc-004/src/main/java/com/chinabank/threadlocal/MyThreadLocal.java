package com.chinabank.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {
    private Map<Thread, T> map = new HashMap<>();

    public void set(T obj) {
        map.put(Thread.currentThread(), obj);
    }

    public void remove() {
        map.remove(Thread.currentThread());
    }

    public T get() {
        return map.get(Thread.currentThread());
    }
}
