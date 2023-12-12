package org.example.spring6.bean__JianDanLeiXing;

public class Clazz {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

//    public String getName() {
//        return name;
//    }

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }
}
