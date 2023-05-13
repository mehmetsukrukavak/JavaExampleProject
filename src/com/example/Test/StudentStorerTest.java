package com.example.Test;

import com.example.entities.Student;
import com.example.functions.StudentStorer;

import java.util.ArrayList;
import java.util.List;

public class StudentStorerTest {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student student0 = new Student(100, "Mehmet şükrü Kavak", 5.98);
        Student student1 = new Student();
        student1.setStudentId(101);
        student1.setStudentName("Esra Mete Kavak");
        student1.setAverageMark(6.38);

        studentList.add(student0);
        studentList.add(student1);

        StudentStorer studentStorer = new StudentStorer("student.txt");
        studentStorer.setFieldDelimiter("|");
        studentStorer.setNewline("\r\n");
        studentStorer.store(studentList);
    }

}
