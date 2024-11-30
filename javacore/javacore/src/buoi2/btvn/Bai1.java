package buoi2.btvn;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào điểm sinh viên");
        System.out.print("Điểm chuyên cần: ");
        double diemChuyenCan = sc.nextDouble();
        System.out.print("Điểm giữa kỳ: ");
        double diemGiuaKy = sc.nextDouble();
        System.out.print("Điểm cuối kỳ2: ");
        double diemCuoiKy = sc.nextDouble();
        double diemTrungBinh;
        String loai = "";
        diemTrungBinh = (diemChuyenCan + diemGiuaKy + diemCuoiKy)/3;
        if(diemTrungBinh > 9){
            loai = "A";
        } else if (diemTrungBinh > 7) {
            loai = "B";
        } else if (diemTrungBinh > 5) {
            loai = "C";
        }else {
            loai = "D";
        }
        System.out.println("Xếp loại điểm sinh viên: " + loai);
    }
}
