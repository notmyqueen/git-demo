package com.chinabank.utils;

import java.sql.Connection;

public class MyThreadLocal {
    public void getMap() {
        Thread thread = Thread.currentThread();
        ThreadLocal<Connection> local = new ThreadLocal<>();
    }
}
