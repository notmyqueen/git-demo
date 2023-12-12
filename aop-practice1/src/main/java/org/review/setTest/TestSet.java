package org.review.setTest;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();

        //往Set里加元素是add()方法
        names.add("Walter");
        names.add("Skyler");
        names.add("Jesse");
        names.add("Howard");
        names.add("Walter");
        names.add("Walter");

        System.out.println(names);  //[Walter, Howard, Skyler, Jesse]

    }
}
