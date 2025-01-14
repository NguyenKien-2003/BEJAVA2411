package Module2;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManager {
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    ArrayList<Account> accounts = null;
    Scanner scanner = new Scanner(System.in);

    public TransactionManager(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }


    public void chucNangGiaoDichTaiKhoan(AccountManager account) {
        int choice = 0;
        do {
            System.out.println("---------Giao dịch tài khoản---------");
            System.out.println("1.Nạp tiền.");
            System.out.println("2.Rút tiền.");
            System.out.println("3.Chuyển khoản.");
            System.out.println("4.Thoát.");

            System.out.println("Chọn chức năng giao dịch tài khoản:");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        depositMoney();
                        break;
                    case 2:
                        withdrawMoney();
                        break;
                    case 3:
                        banking();
                        break;
                    case 4:
                        System.out.println("Dừng nhập!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                scanner.next();
            }
        } while (choice != 4);
    }

    public void depositMoney() {
        int choice = 0;
        do {
            System.out.println("1. Tiếp tục.");
            System.out.println("2. Thoát!");
            System.out.println("Vui lòng nhập lựa chọn:");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập số tài khoản của khách hàng:");
                        String accountNumber = scanner.nextLine().trim();
                        boolean accountFound = false;


                        for (int i = 0; i < accounts.size(); i++) {
                            if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                                accountFound = true;
                                System.out.println("Nhập số tiền cần nạp: ");
                                double amount = scanner.nextDouble();
                                accounts.get(i).deposit(amount);
                                Transaction transaction = new Transaction(
                                        Account.generateTransactionId(),
                                        accounts.get(i),
                                        accounts.get(i).getEmployeeInCharge(),
                                        "Nạp tiền",
                                        amount
                                );
                                accounts.get(i).getTransactionHistory().add(transaction);

                                transactions.add(transaction);
                                break;
                            }
                        }

                        if (!accountFound) {
                            System.out.println("Tài khoản " + accountNumber + " không tồn tại trong hệ thống. Vui lòng thử lại!");
                        }
                        break;
                    case 2:
                        System.out.println("Thoát thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                scanner.next();
            }
        } while (choice != 2);
    }

    public void withdrawMoney() {
        int choice = 0;
        do {
            System.out.println("1. Tiếp tục.");
            System.out.println("2. Thoát!");
            System.out.println("Vui lòng nhập lựa chọn:");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập số tài khoản của khách hàng:");
                        scanner.nextLine();
                        String accountNumber = scanner.nextLine();
                        boolean accountFound = false;

                        for (int i = 0; i < accounts.size(); i++) {
                            if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                                accountFound = true;
                                System.out.println("Nhập số tiền cần rút: ");
                                double amount = scanner.nextDouble();
                                accounts.get(i).withdraw(amount);
                                // Thêm giao dịch vào lịch sử giao dịch của tài khoản
                                Transaction transaction = new Transaction(
                                        Account.generateTransactionId(),
                                        accounts.get(i),
                                        accounts.get(i).getEmployeeInCharge(),
                                        "Rút tiền",
                                        amount
                                );
                                accounts.get(i).getTransactionHistory().add(transaction);

                                // Thêm giao dịch vào danh sách giao dịch chung của TransactionManager
                                transactions.add(transaction);

                                break;
                            }
                        }

                        if (!accountFound) {
                            System.out.println("Tài khoản " + accountNumber + " không tồn tại trong hệ thống. Vui lòng thử lại!");
                        }
                        break;
                    case 2:
                        System.out.println("Thoát thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                scanner.next();
            }
        } while (choice != 2);
    }

    public void banking() {
        int choice = 0;
        do {
            System.out.println("1. Tiếp tục.");
            System.out.println("2. Thoát!");
            System.out.println("Vui lòng nhập lựa chọn:");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập tài khoản gửi:");
                        String senderAccountNumber = scanner.nextLine();
                        System.out.println("Nhập tài khoản nhận:");
                        String receiverAccountNumber = scanner.nextLine();
                        boolean senderAccountFound = false;
                        boolean receiverAccountFound = false;
                        Account senderAccount = null;
                        Account receiverAccount = null;

                        for (Account account : accounts) {
                            if (account.getAccountNumber().equals(senderAccountNumber)) {
                                senderAccountFound = true;
                                senderAccount = account;
                            }
                            if (account.getAccountNumber().equals(receiverAccountNumber)) {
                                receiverAccountFound = true;
                                receiverAccount = account;
                            }
                        }

                        if (senderAccountFound && receiverAccountFound) {
                            System.out.println("Nhập số tiền cần chuyển: ");
                            double amount = scanner.nextDouble();
                            if (amount <= 0) {
                                System.out.println("Số tiền chuyển phải lớn hơn 0. Vui lòng thử lại!");
                                return;
                            }

                            if (senderAccount.getBalance() < amount) {
                                System.out.println("Số dư không đủ để thực hiện chuyển khoản. Vui lòng thử lại!");
                            } else {
                                senderAccount.withdraw(amount);
                                receiverAccount.deposit(amount);

                                Transaction transactionSend = new Transaction(
                                        Account.generateTransactionId(), senderAccount, senderAccount.getEmployeeInCharge(), "Chuyển tiền", amount
                                );
                                senderAccount.getTransactionHistory().add(transactionSend);


                                Transaction transactionReceive = new Transaction(
                                        Account.generateTransactionId(), receiverAccount, receiverAccount.getEmployeeInCharge(), "Nhận tiền", amount
                                );
                                receiverAccount.getTransactionHistory().add(transactionReceive);
                                transactions.add(transactionSend);
                                transactions.add(transactionReceive);

                                System.out.println("Chuyển tiền từ tài khoản " + senderAccount.getAccountNumber() + " đến tài khoản " + receiverAccount.getAccountNumber() + " thành công ! ");


                            }
                        } else {
                            if (!senderAccountFound) {
                                System.out.println("Tài khoản gửi " + senderAccount + " không tồn tại.");
                            }
                            if (!receiverAccountFound) {
                                System.out.println("Tài khoản nhận " + receiverAccount + " không tồn tại.");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Dừng nhập!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                scanner.next();
            }
        } while (choice != 2);
    }

    public void showTransactionHistory() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("---------Lịch sử giao dịch---------");
            System.out.println("1. Hiển thị lịch sử giao dịch theo số tài khoản");
            System.out.println("2. Hiển thị toàn bộ lịch sử giao dịch");
            System.out.println("3. Thoát");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhập số tài khoản: ");
                    String accountNumber = scanner.nextLine();
                    showTransactionForAccount(accountNumber);
                    break;
                case 2:
                    showAllTransactions();
                    break;
                default:
                    System.out.println("Nhap lai !");

            }
        } while (choice != 3);

    }

    public void showTransactionForAccount(String accountNumber) {
        Account accountFound = null;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accountFound = account;
                break;
            }
        }
        if (accountFound == null) {
            System.out.println("Tài khoản " + accountNumber + " không tồn tại.");
            return;
        }

        if (accountFound.getTransactionHistory().isEmpty()) {
            System.out.println("Tài khoản " + accountNumber + " không có giao dịch nào.");
        } else {
            System.out.println("------Danh sach giao dich cua tai khoan " + accountNumber + "------");
            for (Transaction t : accountFound.getTransactionHistory()) {
                System.out.println(t.toString());
            }
        }
    }

    public void showAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Không có giao dịch nào trong hệ thống.");
        } else {
            System.out.println("Danh sách toàn bộ giao dịch:");
            for (Transaction t : transactions) {
                System.out.println(t.toString());
            }
        }
    }

}
