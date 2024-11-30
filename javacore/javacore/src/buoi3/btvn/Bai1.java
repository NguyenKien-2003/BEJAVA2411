package buoi3.btvn;

public class Bai1 {
    public static void main(String[] args) {
        int totalAmount = 20000;
        findCombinations(totalAmount);
    }
    public static void findCombinations(int totalAmount) {
        for (int x1 = 0; x1 <= totalAmount / 1000; x1++) {
            for (int x2 = 0; x2 <= totalAmount / 2000; x2++) {
                for (int x3 = 0; x3 <= totalAmount / 5000; x3++) {
                    if (x1 * 1000 + x2 * 2000 + x3 * 5000 == totalAmount) {
                        System.out.println("1000đ: " + x1 + " tờ, 2000đ: " + x2 + " tờ, 5000đ: " + x3 + " tờ");
                    }
                }
            }
        }
    }
}
