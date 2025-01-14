package Module2;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    ArrayList<Employee> employees = new ArrayList<>();

    public ArrayList<Employee> getEmployeess() {
        return employees;
    }

    public boolean isemployeeCodeExist(String id) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void chonChucNangQuanLyNhanVien() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("---------Quản lý nhân viên---------");
            System.out.println("1.Thêm nhân viên mới.");
            System.out.println("2.Xem danh sách nhân viên.");
            System.out.println("3.Thoát!");
            System.out.println("------------------------------------");
            System.out.println("Chọn chức năng: ");
            try {

                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                scanner.next();
            }
        } while (choice != 3);
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào trong hệ thống!!!");
        } else {
            System.out.println("---------Danh sách nhân viên---------");
            for (Employee e : employees) {
                System.out.println("ID: " + e.getId() + "\tTên nhân viên: " + e.getName() + "\tLương cơ bản: " + e.getSalary());
                System.out.print("\tTài khoản đang quản lý: ");
                if (e.getManagedAccount().isEmpty()) {
                    System.out.println("Không có tài khoản nào.");
                } else {
                    for (Account account : e.getManagedAccount()) {
                        System.out.println("\n\t\t- Số tài khoản: " + account.getAccountNumber() +
                                ", Chủ tài khoản: " + account.getAccountHolder() +
                                ", Số dư: " + account.getBalance());
                    }
                }

            }
        }
    }

    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("---------Menu Thêm Nhân Viên---------");
            System.out.println("1.Tiếp tục.");
            System.out.println("2.Thoát.");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập thông tin nhân viên:");
                        System.out.print("ID nhân viên: ");
                        String id = sc.next();
                        System.out.print("Tên nhân viên: ");
                        String name = sc.next();
                        System.out.print("Lương cơ bản: ");
                        double salary = sc.nextDouble();
                        if (isemployeeCodeExist(id)) {
                            System.out.println("Mã nhân viên " + id + " đã tồn tại. Không thể thêm nhân viên!");
                        } else {
                            employees.add(new Employee(id, name, salary, null));
                            System.out.println("Nhân viên đã được thêm!");
                        }
                        break;
                    case 2:
                        System.out.println("Dừng nhập");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.next();
            }

        } while (choice != 2);

    }
}
