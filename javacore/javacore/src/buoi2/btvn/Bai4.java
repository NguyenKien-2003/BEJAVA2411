package buoi2.btvn;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("----------------------------");
            System.out.println("1. Tính điểm sinh viên ");
            System.out.println("2. Kiểm tra loại tam giác");
            System.out.println("3. Tính tiền điện");
            System.out.println("4. Kết thúc chương trình");
            System.out.println("----------------------------");
            System.out.println("Chọn chức năng : ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    xepLoaiDiemSinhVien();
                    break;
                case 2:
                    kiemTraTamGiac();
                    break;
                case 3:
                    tinhTienDien();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình !");
                    break;

                default:
                    System.out.println("Chương trình không hợp lệ !");
            }

        }while(choice != 4);
        sc.close();
    }
    public static void xepLoaiDiemSinhVien() {
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

    public static void kiemTraTamGiac(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào các cạnh của tam giác ");
        System.out.print("Cạnh a: ");
        double a = sc.nextDouble();
        System.out.print("Cạnh b: ");
        double b = sc.nextDouble();
        System.out.print("Cạnh c: ");
        double c = sc.nextDouble();
        if(a+b>c && a+c>b && b+c>a){
            if(a == b && a == c){
                System.out.println("Đây là tam giác đều ");
            }
            if(a == b ||b == c || a == c){
                System.out.println("Đây là tam giác cân ");
            }
            if(kiemTraTamGiacVuong(a,b,c)){
                System.out.println("Đây là tam giác vuông");
            }
            else {
                System.out.println("Đây là tam giác thường");
            }

        }else {
            System.out.println("Các cạnh nhập vào không thể tạo thành một tam giác !");
        }
    }
    public static boolean kiemTraTamGiacVuong(double a, double b, double c){
        if(a>b && a>c){
            return a*a == b*b + c*c;
        } else if (b>a && b>c) {
            return b*b == a*a + c*c;
        }else {
            return c*c == a*a + b*b;
        }
    }
    public static void tinhTienDien(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số điện: ");
        float soDien = sc.nextFloat();
        float soDienMuc1 = 50;
        float soDienMuc2 = 100;
        float soDienMuc3 = 200;
        float soDienMuc4 = 300;
        float soDienMuc5 = 400;
        float giaDienMuc1 = 1678;
        float giaDienMuc2 = 1734;
        float giaDienMuc3 = 2014;
        float giaDienMuc4 = 2536;
        float giaDienMuc5 = 2834;
        float giaDienMuc6 = 2927;
        float tienDien;
        if(soDien < 0){
            System.out.println("Số điện không hợp lệ !");
            return;
        }
        if(soDien <= soDienMuc1){
            tienDien = soDien * giaDienMuc1;
        } else if (soDien <= soDienMuc2) {
            tienDien = soDienMuc1 * giaDienMuc1
                    + (soDien - soDienMuc1) * giaDienMuc2;
        } else if (soDien <= soDienMuc3) {
            tienDien = soDienMuc1 * giaDienMuc1
                    + (soDienMuc2 - soDienMuc1) * giaDienMuc2
                    + (soDien - soDienMuc2) * giaDienMuc3;
        } else if (soDien <= soDienMuc4) {
            tienDien = soDienMuc1 * giaDienMuc1
                    + (soDienMuc2 - soDienMuc1) * giaDienMuc2
                    + (soDienMuc3 - soDienMuc2) * giaDienMuc3
                    + (soDien- soDienMuc3) * giaDienMuc4;
        } else if (soDien <= soDienMuc5) {
            tienDien = soDienMuc1 * giaDienMuc1
                    + (soDienMuc2 - soDienMuc1) * giaDienMuc2
                    + (soDienMuc3 - soDienMuc2) * giaDienMuc3
                    + (soDienMuc4 - soDienMuc3) * giaDienMuc4
                    + (soDien- soDienMuc4) * giaDienMuc5;
        } else {
            tienDien = soDienMuc1 * giaDienMuc1
                    + (soDienMuc2 - soDienMuc1) * giaDienMuc2
                    + (soDienMuc3 - soDienMuc2) * giaDienMuc3
                    + (soDienMuc4 - soDienMuc3) * giaDienMuc4
                    + (soDienMuc5 - soDienMuc4) * giaDienMuc5
                    + (soDien - soDienMuc5) * giaDienMuc6;
        }
        System.out.println("Tổng số tiền điện: " +tienDien);
    }
}
