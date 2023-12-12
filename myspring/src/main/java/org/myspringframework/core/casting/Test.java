package org.myspringframework.core.casting;

public class Test {
    public static void main(String[] args) {
        Animal wangcai = new Dog();
        System.out.println(wangcai);

        Animal a1= new Dog();
        Dog d1 = (Dog) a1;
        d1.bark();
    }
}
