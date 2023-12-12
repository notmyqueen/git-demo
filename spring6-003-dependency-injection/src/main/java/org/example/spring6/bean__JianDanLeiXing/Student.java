package org.example.spring6.bean__JianDanLeiXing;

public class Student {
    private String name;
    private int age;
    private Clazz clazz;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Clazz getClazz() {
        return clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", clazz=" + clazz +
                '}';
    }
}
