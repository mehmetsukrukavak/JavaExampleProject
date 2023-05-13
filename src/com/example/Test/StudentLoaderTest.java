package com.example.Test;

import com.example.entities.Student;
import com.example.functions.StudentLoader;
import java.util.List;

public class StudentLoaderTest {
    public static void main(String[] args) {
        StudentLoader studentLoader = new StudentLoader("student_.txt");
        //studentLoader.setFilePath("student.txt");
        studentLoader.setFieldDelimiter("|");
        List<Student> studentList = studentLoader.load();

        for(Student student: studentList){
            System.out.printf("%d %-20s %4.2f \r\n", student.getStudentId(), student.getStudentName(), student.getAverageMark());

        }

    }
}
