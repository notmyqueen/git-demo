package com.example.spring6.bean;

/*
    具体工厂角色
 */
public class DaggerFactory {
    //注意这是成员方法，不是静态方法
    public Dagger get() {
        return new Dagger();
    }
}
