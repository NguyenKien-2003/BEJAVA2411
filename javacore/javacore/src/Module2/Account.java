package Module2;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private Employee employeeInCharge;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, String accountHolder, double balance, Employee employeeInCharge) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.employeeInCharge = employeeInCharge;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Employee getEmployeeInCharge() {
        return employeeInCharge;
    }

    public void setEmployeeInCharge(Employee employeeInCharge) {
        this.employeeInCharge = employeeInCharge;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền nạp phải lớn hơn 0 !");
            return;
        }
        balance += amount;
        System.out.println("Đã nạp: " + amount);
        System.out.println("Số dư: " + balance);
        Transaction transaction = new Transaction(
                generateTransactionId(),
                this,
                employeeInCharge,
                "Deposit",
                amount
        );
        transactionHistory.add(transaction);

    }

    public class khongDuTienException extends Exception {
        public khongDuTienException(String message) {
            super(message);
        }
    }

    public void withdraw(double amount) throws khongDuTienException {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0 !");
            }

            if (amount > balance) {
                throw new khongDuTienException(
                        "Số dư không đủ để rút. Số dư hiện tại: " + balance
                );
            }
            balance -= amount;
            System.out.println("Đã rút: " + amount);
            System.out.println("Số dư: " + balance);
            Transaction transaction = new Transaction(
                    generateTransactionId(),
                    this,
                    employeeInCharge,
                    "Withdraw",
                    amount
            );
            transactionHistory.add(transaction);
        } catch (khongDuTienException | IllegalArgumentException e) {
            System.out.println("Lỗi :" + e.getMessage());

        }


    }


    public void showInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Employee In Charge: " + employeeInCharge.toString());
    }

    public static String generateTransactionId() {
        return "TXN-" + System.currentTimeMillis();
    }

}