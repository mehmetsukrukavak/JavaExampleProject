package com.example.functions;

import com.example.entities.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StudentLoader {
    private String filePath;
    private String fieldDelimiter = "|";


    public StudentLoader() {
    }

    public StudentLoader(String filePath) {
        this.filePath = filePath;

    }

    public List<Student> load() {
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Student student = parse(line);
                studentList.add(student);
            }

            System.out.println("Okuma Tamamlandı...");
        } catch (Exception e) {
            System.out.println("Hata Oluştu");
            e.printStackTrace();
        }
        return studentList;
    }

    private Student parse(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line, fieldDelimiter);
        long studentId = Long.parseLong(tokenizer.nextToken());
        String studentName = tokenizer.nextToken();
        double studentAverageMark = Double.parseDouble(tokenizer.nextToken());

        Student student = new Student(studentId, studentName, studentAverageMark);

        return student;

    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFieldDelimiter() {
        return fieldDelimiter;
    }

    public void setFieldDelimiter(String fieldDelimiter) {
        this.fieldDelimiter = fieldDelimiter;
    }


}
