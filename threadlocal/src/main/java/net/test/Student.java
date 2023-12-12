package net.test;

public class Student {
    //“张三”可以在new完对象后直接访问：new Student().name =》输出张三
    //也可以直接修改，new Student().name = "李四"; 张三就变成了李四
    public String name = "张三";

    //由于是private修饰的变量，因此无法直接访问，要通过get方法访问。修改也只能用set方法。
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
