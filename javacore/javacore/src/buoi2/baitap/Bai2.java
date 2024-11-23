package buoi2.baitap;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao a: ");
        int a = sc.nextInt();
        System.out.println("Nhap vao b: ");
        int b = sc.nextInt();


        if (a == 0){
             if(b==0){
                 System.out.println("Phuong trinh co vo so nghiem");
             }else {
                 System.out.println("Phuong trinh vo nghiem");
             }
         }else {
            System.out.println("Phuong trinh co nghiem x = " + -b/a);
        }
    }
}
