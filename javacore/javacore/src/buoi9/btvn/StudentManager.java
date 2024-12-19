package buoi9.btvn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private HashSet<String> studentIds = new HashSet<>();

    // Thêm sinh viên
    public void addStudent(String id, String name, double grade) {
        if (studentIds.contains(id)) {
            throw new RuntimeException("Student with ID " + id + " already exists.");
        }
        Student student = new Student(id, name, grade);
        students.add(student);
        studentIds.add(id);
    }

    // Xóa sinh viên
    public void deleteStudent(String id) {
        boolean removed = false;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                studentIds.remove(id);
                removed = true;
                break;
            }
        }
        if (!removed) {
            throw new RuntimeException("Student with ID " + id + " not found.");
        }
    }

    // Hiển thị danh sách sinh viên
    public void showStudents() {
        if (students.isEmpty()) {
            throw new RuntimeException("No students available.");
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Tìm kiếm sinh viên theo tên
    public void searchStudentByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            throw new RuntimeException("No student found with name: " + name);
        }
    }

    // Sắp xếp danh sách sinh viên theo điểm thi
    public void sortStudentsByGrade() {
        if (students.isEmpty()) {
            throw new RuntimeException("No students to sort.");
        }
        Collections.sort(students, (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade()));
    }

    // Kiểm tra sinh viên có tồn tại không
    public boolean checkStudentExist(String id) {
        return studentIds.contains(id);
    }
}
