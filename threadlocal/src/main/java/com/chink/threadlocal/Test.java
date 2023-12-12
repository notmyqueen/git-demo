package com.chink.threadlocal;

public class Test {
    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(thread);

        Connection conn = new Connection();

        UserService userService = new UserService();
        userService.save(conn);
    }
}

//自己的迷惑点，也就是重点：Dao和Service都要调一次DBUtil.getConnection()方法。调了之后，大Map（local）就把thread和conn绑定在了一起。
