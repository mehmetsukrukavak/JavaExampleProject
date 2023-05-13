package com.example.Test;

import com.example.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        Student student0 = new Student(100, "Mehmet Şükrü Kavak", 5.98);
        System.out.println(student0.getStudentId());
        System.out.println(student0.getStudentName());
        System.out.printf("%4.2f \r\n", student0.getAverageMark());
        System.out.println();
        Student student1 = new Student();
        student1.setStudentId(101);
        student1.setStudentName("Esra Mete Kavak");
        student1.setAverageMark(6.38);
        System.out.println(student1.getStudentId());
        System.out.println(student1.getStudentName());
        System.out.printf("%4.2f \r\n", student1.getAverageMark());

        System.out.println();
        studentList.add(student0);
        studentList.add(student1);

        for (Student student : studentList) {
            System.out.printf("%d %-20s %4.2f \r\n", student.getStudentId(), student.getStudentName(), student.getAverageMark());

        }

    }
}
