package Module2;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Employee> employees = null;

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public AccountManager(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void quanLyAccount() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {
            do {
                System.out.println("---------Quản lý tài khoản---------");
                System.out.println("1.Thêm tài khoản mới.");
                System.out.println("2.Sửa thông tin tài khoản.");
                System.out.println("3.Xóa tài khoản.");
                System.out.println("4.Tìm kiếm tài khoản.");
                System.out.println("5.Hiển thị tất cả tài khoản.");
                System.out.println("6.Thoát chương trình");
                System.out.println("------------------------------------");
                System.out.println("Chọn chức năng quản lý tài khoản: ");

                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        addAccount();
                        break;
                    case 2:
                        updateAccount();
                        break;
                    case 3:
                        deleteAccount();
                        break;
                    case 4:
                        searchAccount();
                        break;
                    case 5:
                        showAllAccount();
                        break;
                    case 6:
                        System.out.println("Thoát!");
                        break;

                }
            } while (choice != 6);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public boolean isManagerExist(String managerAccountNumber) {
        for (Employee e : employees) {
            if (e.getId().equals(managerAccountNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAccountCodeExist(String accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public void addAccount() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {
            do {
                System.out.println("---------Menu Thêm Tài Khoản Mới---------");
                System.out.println("1.Tiếp tục");
                System.out.println("2.Thoát.");
                System.out.println("Vui lòng nhập lựa chọn: ");

                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập thông tin tài khoản:");
                        System.out.println("Số tài khoản: ");
                        String accountNumber = scanner.nextLine();
                        System.out.println("Chủ tài khoản: ");
                        String accountHolder = scanner.nextLine();
                        System.out.println("Số dư ban đầu: ");
                        double balance = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Nhân viên quản lí(Nhập mã nhân viên):");
                        String managerAccountNumber = scanner.nextLine();
                        if (isAccountCodeExist(accountNumber)) {
                            System.out.println("Thêm không thành công!Số tài khoản " + accountNumber + " đã tồn tại trong hệ thống.");
                            System.out.println("Vui lòng chọn Số tài khoản khác.");
                        } else if (!isManagerExist(managerAccountNumber)) {
                            System.out.println("Mã nhân viên không tồn tại trong hệ thống. Vui lòng kiểm tra lại.");

                        } else {
                            Employee manager = null;
                            for (Employee employee : employees) {
                                if (employee.getId().equals(managerAccountNumber)) {
                                    manager = employee;
                                    break;
                                }
                            }
                            if (manager != null) {
                                Account newAccount = new Account(accountNumber, accountHolder, balance, manager);
                                manager.addAccount(newAccount);
                                accounts.add(newAccount);
                                System.out.println("Thêm tài khoản thành công!");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Dừng nhập!");
                        break;
                    default:
                        System.out.println("Nhập giá trị không hợp lệ! Vui lòng nhập lại");
                }
            } while (choice != 2);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void showAllAccount() {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) == null) {
                continue;
            }
            System.out.println("------------- Tài khoản: " + i);
            accounts.get(i).showInfo();
        }
    }

    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    private Account findAccountByHolderName(String holderName) {
        for (Account account : accounts) {
            if (account.getAccountHolder().equals(holderName)) {
                return account;
            }
        }
        return null;
    }

    public void updateAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------Sửa Thông Tin Tài Khoản---------");
        System.out.println("Nhập số tài khoản cần sửa: ");
        String accountNumber = scanner.nextLine();

        Account accountToUpdate = findAccount(accountNumber);
        if (accountToUpdate != null) {


            int choice = 0;
            do {
                System.out.println("--------Sửa thông tin tài khoản-------");
                System.out.println("1. Sửa chủ tài khoản");
                System.out.println("2. Sửa số dư tài khoản");
                System.out.println("3. Thoát");
                System.out.println("Chọn thông tin cần sửa: ");

                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập tên chủ tài khoản mới:");
                        String newAccountHolder = scanner.nextLine();
                        accountToUpdate.setAccountHolder(newAccountHolder);
                        System.out.println("Chủ tài khoản đã được cập nhật: " + accountToUpdate.getAccountHolder());
                        break;
                    case 2:
                        System.out.println("Nhập số dư mới: ");
                        double newBalance = scanner.nextDouble();
                        scanner.nextLine();
                        if (newBalance < 0) {
                            System.out.println("Số dư không thể nhỏ hơn 0 !");
                            return;
                        }
                        accountToUpdate.setBalance(newBalance);
                        System.out.println("Số dư tài khoản đã cập nhật: " + accountToUpdate.getBalance());
                        break;
                    case 3:
                        System.out.println("Thoát");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ !");
                }
            } while (choice != 3);
        } else {
            System.out.println("Tài khoản không tồn tại !");
        }
    }

    public void deleteAccount() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("---------Xóa tài khoản---------");
            System.out.println("1. Tiếp tục.");
            System.out.println("2. Thoát.");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhập tài khoản muốn xóa:");
                    String removeAccountNumber = scanner.nextLine();
                    Account accountToRemove = findAccount(removeAccountNumber);
                    if (accountToRemove != null) {
                        double balance = accountToRemove.getBalance();
                        if (balance > 0) {
                            System.out.println("Tài khoản vẫn còn số dư: " + balance + ". Vui lòng rút hết trước khi xóa.");
                            System.out.println("Nhập số tiền cần rút:");
                            double amount = scanner.nextDouble();

                            if (amount <= balance) {
                                try {
                                    accountToRemove.withdraw(amount);
                                    System.out.println("Đã rút: " + amount);
                                    balance -= amount;
                                    if (balance == 0) {
                                        accounts.remove(accountToRemove);
                                        System.out.println("Tài khoản " + removeAccountNumber + " đã được xóa thành công.");
                                    } else {
                                        System.out.println("Vui lòng rút hết tiền trước khi xóa tài khoản ! Số dư còn lại : " + balance);
                                        return;
                                    }

                                } catch (Account.khongDuTienException e) {
                                    System.out.println("Số dư không đủ !" + e.getMessage());
                                }
                            } else {
                                System.out.println("Số tiền rút vượt quá số dư tài khoản!");
                                return;
                            }
                        }


                    } else {
                        System.out.println("Số tài khoản " + removeAccountNumber + " không tồn tại trong hệ thống. Vui lòng thử lại!");
                    }
                    break;
                case 2:
                    System.out.println("Thoát thành công!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                    break;
            }
        } while (choice != 2);
    }

    public void searchAccount() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. Tim voi so tai khoan: ");
            System.out.println("2. Tim voi ten chu tai khoan");
            System.out.println("3. Thoat");
            System.out.println("Nhap vao chuc nang muon su dung: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhap vao so tai khoan: ");
                    String accountNumber = scanner.nextLine();
                    Account accountFindByID = findAccount(accountNumber);
                    if (accountFindByID != null) {
                        System.out.println("So tai khoan: " + accountFindByID.getAccountNumber() + " Chu tai khoan: " + accountFindByID.getAccountHolder() + " So du tai khoan: " + accountFindByID.getBalance());
                    } else {
                        System.out.println("Khong tim thay tai khoan : " + accountNumber);
                    }
                    break;
                case 2:
                    System.out.println("Nhap ten chu tai khoan: ");
                    String accountHolder = scanner.nextLine();
                    Account accountFindByHolder = findAccountByHolderName(accountHolder);
                    if (accountFindByHolder != null) {
                        System.out.println("So tai khoan: " + accountFindByHolder.getAccountNumber() + " Chu tai khoan: " + accountFindByHolder.getAccountHolder() + " So du tai khoan: " + accountFindByHolder.getBalance());
                    } else {
                        System.out.println("Khong tim thay chu tai khoan : " + accountHolder);
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Vui long nhap lai !");
            }
        } while (choice != 3);
    }
}
