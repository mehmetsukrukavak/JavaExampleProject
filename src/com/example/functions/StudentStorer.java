package com.example.functions;

import com.example.entities.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class StudentStorer {
    private String filePath;
    private String fieldDelimiter = "|";
    private String newline = "\r\n";
    public StudentStorer() {
    }

    public StudentStorer(String filePath) {
        this.filePath = filePath;
    }
    public void store(List<Student> studentList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : studentList) {
                String line = format(student);
                bw.write(line);
            }

            System.out.println("Saklama Tamamlandı.....");
        } catch (Exception e) {
            System.out.println("Hata Oluştu");
            e.printStackTrace();
        }
    }

    private String format(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getStudentId()).append(fieldDelimiter);
        sb.append(student.getStudentName()).append(fieldDelimiter);
        sb.append(student.getAverageMark()).append(newline);
        return sb.toString();
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

    public String getNewline() {
        return newline;
    }

    public void setNewline(String newline) {
        this.newline = newline;
    }
}
