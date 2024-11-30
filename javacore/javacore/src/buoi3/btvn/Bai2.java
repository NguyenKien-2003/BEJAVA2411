package buoi3.btvn;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số thập phân: ");
        int soThapPhan = sc.nextInt();



        if (soThapPhan == 0) {
            System.out.println("Số nhị phân là: 0");
        } else {
            String soNhiPhan = "";
            int chuSo = 0;

            while (soThapPhan > 0) {
                chuSo = soThapPhan % 2;
                soNhiPhan = chuSo + soNhiPhan;
                soThapPhan /= 2;
            }

            System.out.println("Số nhị phân là: " + soNhiPhan);
        }
    }
}
