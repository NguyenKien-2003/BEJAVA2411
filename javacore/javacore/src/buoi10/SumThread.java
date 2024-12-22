package buoi10;

import java.sql.SQLOutput;

public class SumThread  extends Thread {
    private int start;
    private int end;
    private int result = 0;

    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            result += i;
        }
        System.out.println("Tổng từ " + start + " đến " +end + " là: " + result);

    }
    public int getResult() {
        return result;
    }
}
