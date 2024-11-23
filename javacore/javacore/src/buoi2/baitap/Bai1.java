package buoi2.baitap;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        System.out.println("Nhap vao gio lam viec: ");
        double gioLamViec = new Scanner(System.in).nextDouble();
        double luong = 50000;
        double soGioTieuChuan = 40;
        double heSo = 1.5;
        double tongLuong;
        if (gioLamViec < soGioTieuChuan){
            tongLuong = gioLamViec*luong;
        }else {
            tongLuong = (soGioTieuChuan*luong) + (gioLamViec-soGioTieuChuan)*luong*heSo;
        }
        System.out.println("Tong luong: " + tongLuong);

    }

}
