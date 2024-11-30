package buoi3.baiTap;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số: ");
        int n = sc.nextInt();
        int nDaoNguoc = 0;
        int chuSo;
        while (n!=0){
            chuSo = n % 10;
            System.out.println(chuSo);
            nDaoNguoc = nDaoNguoc * 10 + chuSo;
            n = n / 10;
        }
        System.out.println("Số đảo ngược: " + nDaoNguoc );
    }
}
