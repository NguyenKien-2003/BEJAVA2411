package Module2;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private Account account;
    private Employee employee;
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String transactionId, Account account, Employee employee, String type, double amount) {
        this.transactionId = account.generateTransactionId();
        this.account = account;
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "Transaction id: " + transactionId +
                ",Tài khoản: " + account.getAccountNumber() +
                ",Nhân viên: " + employee.getName() +
                ",Loại giao dịch: " + type +
                ",Số tiền giao dịch: " + amount +
                ",Thời gian: " + timestamp;
    }


}
