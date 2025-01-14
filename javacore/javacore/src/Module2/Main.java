package Module2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        ArrayList<Employee> employees = employeeManager.getEmployeess();
        AccountManager accountManager = new AccountManager(employees);
        ArrayList<Account> accounts = accountManager.getAccounts();
        TransactionManager transactionManager = new TransactionManager(accounts);
        employees.add(new Employee("123", "kien", 20000, null));
        employees.add(new Employee("122", "kien", 20000, null));
        employees.add(new Employee("111", "kien", 20000, null));
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("----------Menu----------");
            System.out.println("1.Quản lý tài khoản.");
            System.out.println("2.Giao dịch tài khoản.");
            System.out.println("3.Quản lý giao dịch.");
            System.out.println("4.Quản lý nhân viên.");
            System.out.println("5.Thoát Chương Trình !!!");
            System.out.println("-------------------------");
            System.out.println("Nhập lựa chọn của bạn:");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        accountManager.quanLyAccount();
                        break;
                    case 2:
                        transactionManager.chucNangGiaoDichTaiKhoan(accountManager);
                        break;
                    case 3:
                        transactionManager.showTransactionHistory();
                        break;
                    case 4:
                        employeeManager.chonChucNangQuanLyNhanVien();
                        break;
                    case 5:
                        System.out.println("Thoát chương trình!");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                scanner.next();
            }


        } while (choice != 5);
    }
}
