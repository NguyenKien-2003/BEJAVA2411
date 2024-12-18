package TestModule1;

import java.util.Scanner;

public class Student {
    private String fullName;
    private int age;
    private int studentCode;

    public Student(String fullName, int age, int studentCode) {
        this.fullName = fullName;
        this.age = age;
        this.studentCode = studentCode;
    }

    public Student() {
    }

    public void showInfo() {
        System.out.println("Tên sinh viên: " + this.fullName);
        System.out.println("Tuổi: " + this.age);
        System.out.println("Mã sinh viên: " + this.studentCode);
    }

    public void enterInfo() {
        System.out.println("Nhập tên sinh viên: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.println("Nhập tuổi sinh viên: ");
        this.age = new Scanner(System.in).nextInt();
        System.out.println("Nhập mã sinh viên: ");
        this.studentCode = new Scanner(System.in).nextInt();

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }
}