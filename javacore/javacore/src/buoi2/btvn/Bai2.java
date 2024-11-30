package buoi2.btvn;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
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
}
