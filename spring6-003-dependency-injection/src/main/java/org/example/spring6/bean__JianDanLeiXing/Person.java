package org.example.spring6.bean__JianDanLeiXing;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
    //注入List集合
    private List<String> names;

    //注入Set集合
    private Set<String> addresses;

    //注入Map集合
    private Map<Integer, String> phoneNumbers;

    //注入Properties属性类对象
    //Properties本质上也是Map集合，Properties的父类Hashtable，实现了Map接口
    //虽然这个也是一个Map集合，但是和Map的注入方式有点像，但是不同。
    //Properties的key和value只能是String类型
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    //一个人有多个名字
    public void setNames(List<String> names) {
        this.names = names;
    }

    //一个人有多个地址
    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }

    public void setPhoneNumbers(Map<Integer, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addresses=" + addresses +
                ", phoneNumbers=" + phoneNumbers +
                ", properties=" + properties +
                '}';
    }
}
