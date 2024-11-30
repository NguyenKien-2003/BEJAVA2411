package buoi3.baiTap;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào n: ");
        int n = sc.nextInt();
        int S = 0;
        for (int i = 1; i <= n; i++) {
            S += Math.pow(i, 3);
        }
        System.out.println("Dãy S(n) = " +S);
    }
}
