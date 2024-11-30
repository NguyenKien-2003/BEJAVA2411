package buoi4.baitap;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n: ");
        int n = sc.nextInt();
        int[] mangBai1 = new int[n];
        String duLieuMang = "";
        int tong = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap vao phan tu thu " + (i+1) + " :");
            mangBai1[i] = sc.nextInt();
            duLieuMang = duLieuMang + mangBai1[i] + " ";

        }
        System.out.println(duLieuMang);
        for (int i = 0; i < mangBai1.length; i++) {
            tong += mangBai1[i];
        }
        System.out.println(tong);
        int soNhoNhat = mangBai1[0];
        int soLonNhat = mangBai1[0];
        for (int i = 0; i < mangBai1.length; i++) {
           if (soNhoNhat > mangBai1[i]) {
               soNhoNhat = mangBai1[i];
           }
           if (soLonNhat < mangBai1[i]) {
               soLonNhat = mangBai1[i];
           }
        }
        System.out.println("So nho nhat: " +soNhoNhat);
        System.out.println("So lon nhat: " +soLonNhat);


    }




}
