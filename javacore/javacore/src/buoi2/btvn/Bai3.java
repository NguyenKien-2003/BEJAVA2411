package buoi2.btvn;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
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
