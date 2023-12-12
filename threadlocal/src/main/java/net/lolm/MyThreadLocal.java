package net.lolm;

import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {
//    private static final Connection conn = new Connection();
    private Map<Thread, T> map = new HashMap<>();

    public void set(T obj) {
        map.put(Thread.currentThread(), obj);
    }

    public T get() {
        return map.get(Thread.currentThread());
    }

    public void remove() {
        map.remove(Thread.currentThread());
    }

}
