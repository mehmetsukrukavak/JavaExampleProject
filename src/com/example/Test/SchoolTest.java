package com.example.Test;

import com.example.entities.School;
import com.example.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class SchoolTest {
    public static void main(String[] args) {
        List<Student> studentList0 = new ArrayList<>();
        Student student0 = new Student(100, "Mehmet Şükrü Kavak", 5.98);

        Student student1 = new Student(101, "Esra Mete Kavak", 6.73);
        List<School> schoolList = new ArrayList<>();

        School school0 = new School(200, "Bizim Lise");
        student0.setSchool(school0);
        student1.setSchool(school0);
        school0.setStudentList(studentList0);
        school0.getStudentList().add(student0);
        school0.getStudentList().add(student1);
        System.out.println(school0.getSchoolId());
        System.out.println(school0.getSchoolName());


        System.out.println();
        List<Student> studentList1 = new ArrayList<>();
        Student student2 = new Student(102, "Fikret Kızılok", 7.98);
        Student student3 = new Student(103, "Bülent Ortaçgil", 3.73);

        School school1 = new School();
        student2.setSchool(school1);
        student3.setSchool(school1);
        school1.setStudentList(studentList1);
        school1.getStudentList().add(student2);
        school1.getStudentList().add(student3);

        school1.addStudent(104, "Beyaz", 5.82);

        school1.setSchoolId(201);
        school1.setSchoolName("Sanat Lisesi");

        System.out.println(school1.getSchoolId());
        System.out.println(school1.getSchoolName());


        System.out.println();
        schoolList.add(school0);
        schoolList.add(school1);

        for (School school : schoolList) {

            System.out.printf("SCHOOL : %d %-20s \r\n",
                    school.getSchoolId(),
                    school.getSchoolName());
            for (Student student : school.getStudentList()) {
              // System.out.printf("\t Student : %d %-20s %4.2f \r\n", student.getStudentId(), student.getStudentName(), student.getAverageMark());
                System.out.println(student);
            }
        }
    }
}
