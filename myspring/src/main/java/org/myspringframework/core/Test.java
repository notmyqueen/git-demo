package org.myspringframework.core;

public class Test {
    public static void main(String[] args) {
        //这不是转型，这是多态。父类应用指向子类对象
        Object obj=null;
        String str = (String) obj;
        str="Abc";
        System.out.println(str);
    }
}
