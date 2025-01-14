package Module2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private String id;
    private String name;
    private double salary;
    private List<Account> managedAccount;

    public Employee(String id, String name, double salary, List<Account> managedAccount) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.managedAccount = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Account> getManagedAccount() {
        return managedAccount;
    }

    public void setManagedAccount(List<Account> managedAccount) {
        this.managedAccount = managedAccount;
    }

    public void addAccount(Account account) {
        this.managedAccount.add(account);
    }

    public void processTransaction(Transaction transaction) {

    }

    @Override
    public String toString() {
        return "Mã nhân viên: " + id + ", Tên nhân viên: " + name;
    }

    Scanner scanner = new Scanner(System.in);

    public void enterInfoEmployee() {
        System.out.println("Nhập ID nhân viên: ");
        this.id = scanner.nextLine();
        System.out.println("Tên nhân viên: ");
        this.name = scanner.nextLine();
        System.out.println("Lương cơ bản: ");
        this.salary = scanner.nextDouble();
    }
}
