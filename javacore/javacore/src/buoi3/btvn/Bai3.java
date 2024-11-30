package buoi3.btvn;
import java.util.Scanner;

public class Bai3 {


    // Kiểm tra số hoàn hảo
    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    // Kiểm tra số Armstrong
    public static boolean isArmstrongNumber(int n) {
        int sum = 0;
        int temp = n;
        int digits = (int) Math.log10(n) + 1;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == n;
    }

    // Kiểm tra số đối xứng (palindrome)
    public static boolean isPalindrome(int n) {
        int original = n;
        int reversed = 0;
        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return original == reversed;
    }

    // Tính tổng các chữ số
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập dãy số
        System.out.print("Nhập dãy số nguyên dương, cách nhau bởi dấu cách: ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");

        // Xử lý từng số trong dãy
        for (String token : tokens) {
            int num = Integer.parseInt(token);

            // Kiểm tra và in thông báo
            System.out.println("Số: " + num);

            // Kiểm tra số hoàn hảo
            if (isPerfectNumber(num)) {
                System.out.println(num + " là số hoàn hảo.");
            } else {
                System.out.println(num + " không phải là số hoàn hảo.");
            }

            // Kiểm tra số Armstrong
            if (isArmstrongNumber(num)) {
                System.out.println(num + " là số Armstrong.");
            } else {
                System.out.println(num + " không phải là số Armstrong.");
            }

            // Kiểm tra số đối xứng
            if (isPalindrome(num)) {
                System.out.println(num + " là số đối xứng.");
            } else {
                System.out.println(num + " không phải là số đối xứng.");
            }

            // Tính tổng các chữ số
            System.out.println("Tổng các chữ số của " + num + " là: " + sumOfDigits(num));
            System.out.println();
        }

        scanner.close();
    }
}
