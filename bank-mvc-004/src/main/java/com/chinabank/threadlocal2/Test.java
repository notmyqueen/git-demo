package com.chinabank.threadlocal2;

public class Test {
    public static void main(String[] args) {
        //这里要注意，输出的两遍connection，虽然是一样的，但是细节还是要注意，第一个是DBUtil里new出来的，第二个是不需要经历这个过程了（判断+set()），直接返回了。
        UserService userService = new UserService();
        userService.transfer();
    }
}
