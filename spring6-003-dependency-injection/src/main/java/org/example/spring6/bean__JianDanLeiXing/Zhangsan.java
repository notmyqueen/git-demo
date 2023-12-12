package org.example.spring6.bean__JianDanLeiXing;

import java.util.Arrays;

public class Zhangsan {
    private String[] hobbies;
    private Student[] students;

    public Zhangsan(String[] hobbies, Student[] students) {
        this.hobbies = hobbies;
        this.students = students;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Zhangsan{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
