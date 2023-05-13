package com.example.console;

import com.example.entities.School;
import com.example.entities.Student;
import com.example.functions.StudentLoader;
import com.example.functions.StudentStorer;

import java.util.List;
import java.util.Scanner;

public class EducationConsole {

    private final static String STUDENT_FILE = "student.txt";
    private static Scanner scanner = new Scanner(System.in);
    private static School school = new School(101, "Minnoş Okul");
    private static StudentStorer studentStorer = new StudentStorer(STUDENT_FILE);

    private static StudentLoader studentLoader = new StudentLoader(STUDENT_FILE);

    private static void printMenu() {
        System.out.println("1. Listele");
        System.out.println("2. Ekle");
        System.out.println("3. Güncelle");
        System.out.println("4. Sil");
        System.out.println("5. Seç");
        System.out.println("8. Yükle");
        System.out.println("9. Sakla");
        System.out.println("0. Çık");
    }

    private static int scanChoice() {
        System.out.println("Lütfen Seçiniz : ");
        int choice = scanner.nextInt();
        System.out.println("Seçiminiz : " + choice);
        return choice;
    }

    private static void handleCommand(int choice) {
        System.out.println("işlenen seçim : " + choice);
        switch (choice) {
            case 1:
                listStudents();
                break;
            case 2:
                InsertStudent();
                break;
            case 3:
                UpdateStudent();
                break;
            case 4:
                DeleteStudent();
                break;
            case 5:
                selectStudent();
                break;

            case 8:
                LoadStudents();
                break;
            case 9:
                StoreStudents();
                break;
            case 0:
                exitConsole(0);
                break;
            default:
                System.out.println("Geçersiz seçim " + choice);
        }
    }

    private static void list(List<Student> studentList) {

        for (Student student : studentList) {
            show(student);
        }

        System.out.println("Öğrenci Sayısı : " + studentList.size());
    }

    private static void show(Student student) {
        System.out.printf("%d %-20s %4.2f \r\n", student.getStudentId(), student.getStudentName(), student.getAverageMark());

    }

    private static void listStudents() {
        System.out.println("Listeleniyor....");
        System.out.printf("\t%d %s\r\n", school.getSchoolId(), school.getSchoolName());
        list(school.getStudentList());
    }

    private static void InsertStudent() {
        System.out.println("Ekleniyor....");
        System.out.println("Öğrenci No   : ");
        long studentId = scanner.nextLong();
        System.out.println("Öğrenci Adı  : ");
        String studentName = scanner.next();
        System.out.println("Öğrenci Notu : ");
        double studentAverageMark = scanner.nextDouble();

//        Student student = new Student(studentId, studentName, studentAverageMark);
//        student.setSchool(school);
//        school.getStudentList().add(student);
        school.addStudent(studentId, studentName, studentAverageMark);
        System.out.println("Öğrenci Başarıyla Eklenmiştir...");

    }

    private static void UpdateStudent() {

        System.out.println("Güncellenecek Öğrenci No   : ");
        long studentId = scanner.nextLong();

        Student student = school.findStudent(studentId);
        if (student != null) {
            show(student);

            System.out.println("Öğrenci Adı  : ");
            String studentName = scanner.next();
            System.out.println("Öğrenci Notu : ");
            double studentAverageMark = scanner.nextDouble();
            System.out.println("Güncelleniyor....");
            student.setStudentName(studentName);
            student.setAverageMark(studentAverageMark);
            System.out.println("Öğrenci Başarıyla Güncellenmiştir...");
        } else {
            System.err.println("Öğrenci Bulunamadı...");
        }
    }

    private static void DeleteStudent() {

        System.out.println("Silinecek Öğrenci No   : ");
        long studentId = scanner.nextLong();

        Student student = school.findStudent(studentId);

        if (student != null) {
            System.out.println("Siliniyor....");

            school.getStudentList().remove(student);
            System.out.println("Öğrenci Başarıyla Silinmiştir...");
        } else {
            System.err.println("Öğrenci Bulunamadı...");
        }
    }

    private static void selectStudent() {
        System.out.println("Seçiliyor....");
        System.out.println("Gösterilecek Öğrenci No   : ");
        long studentId = scanner.nextLong();

        Student student = school.findStudent(studentId);
        if (student != null) {
            show(student);
        } else {
            System.out.println("Öğrenci Bulunamadı...");
        }

    }

    private static void LoadStudents() {
        System.out.println("Yükleniyor....");
       Runnable runnable = new Runnable() {
           @Override
           public void run() {
               try {
                   school.setStudentList(studentLoader.load());
                   System.out.println("Dosyadan Öğrenci Listesi Başarıyla Yüklenmiştir...");
                   list(school.getStudentList());

               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void StoreStudents() {
        System.out.println("Saklanıyor....");

      Runnable runnable = new Runnable() {
          @Override
          public void run() {
              try {

                  studentStorer.store(school.getStudentList());
                  System.out.println("Öğrenci Listesi Başarıyla Saklanmıştır...");
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      };
      Thread thread = new Thread(runnable);
      thread.start();
    }

    private static void exitConsole(int i) {
        System.out.println("Çıkılıyor....");

        System.exit(0);
    }

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanChoice();
            handleCommand(choice);
        }

    }
}
