package buoi3.baiTap;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào n: ");
        int n = sc.nextInt();
        int giaiThuaN = 1;
        for (int i = n;i > 0; i--) {
                giaiThuaN = giaiThuaN * i;

        }
        System.out.println("n! = "+giaiThuaN);
    }
}
