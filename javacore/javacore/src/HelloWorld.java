import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {

    System.out.print("Nhập tên của bạn: ");
    String name = new Scanner(System.in).nextLine();

    System.out.print("Nhập tuổi của bạn: ");
    int age = new Scanner(System.in).nextInt();

    System.out.print("Nhập địa chỉ của bạn: ");
    String address = new Scanner(System.in).nextLine();

    System.out.print("Nhập nghề nghiệp của bạn: ");
    String occupation = new Scanner(System.in).nextLine();

    System.out.println("\n--- Thông tin cá nhân ---");
    System.out.println("Xin chào " + name + "đến từ " + address + "sinh ngay " + age + "học tại " + occupation);


}
}
