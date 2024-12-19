package buoi9.btvn;

import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\nStudent manager System");
                System.out.println("1. Add Student");
                System.out.println("2. Delete Student");
                System.out.println("3. Show Students");
                System.out.println("4. Search Student by Name");
                System.out.println("5. Sort Students by Grade");
                System.out.println("6. Check if Student Exists");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Clear buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student grade: ");
                        double grade = scanner.nextDouble();
                        manager.addStudent(id, name, grade);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter student ID to delete: ");
                        String deleteId = scanner.nextLine();
                        manager.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully.");
                        break;
                    case 3:
                        manager.showStudents();
                        break;
                    case 4:
                        System.out.print("Enter student name to search: ");
                        String searchName = scanner.nextLine();
                        manager.searchStudentByName(searchName);
                        break;
                    case 5:
                        manager.sortStudentsByGrade();
                        System.out.println("Students sorted by grade.");
                        break;
                    case 6:
                        System.out.print("Enter student ID to check: ");
                        String checkId = scanner.nextLine();
                        if (manager.checkStudentExist(checkId)) {
                            System.out.println("Student exists.");
                        } else {
                            System.out.println("Student does not exist.");
                        }
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
