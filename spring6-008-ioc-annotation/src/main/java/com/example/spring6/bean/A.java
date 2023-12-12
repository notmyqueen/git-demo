package com.example.spring6.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Component
public class A {
    public A() {
        System.out.println("A的无参构造执行");
    }
}

@Service
class B {
    public B() {
        System.out.println("B的无参构造执行");
    }
}

@Service
class C {
    public C() {
        System.out.println("C的无参构造执行");
    }
}

@Controller
class D {
    public D() {
        System.out.println("D的无参构造执行");
    }
}
