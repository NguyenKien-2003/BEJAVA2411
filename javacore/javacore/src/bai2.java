import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        System.out.println("Nhap vao 2 so: ");
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        System.out.println("Tong: " + (a + b));
        System.out.println("tich: " + (a*b));
        System.out.println("thuong: " + (a/b));
        System.out.println("chia lay du: " + (a % b));
    }
}
