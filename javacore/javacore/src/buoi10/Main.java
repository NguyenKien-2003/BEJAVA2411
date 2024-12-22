package buoi10;
//Bai1:Cho số n = 10; mục tiêu tính tổng các số từ 1-10tạo ra
//2 thread với yêu cầu thread1: tính tổng các số từ 1-5thread2:
//tính tổng các số từ 6-10sử dụng hàm join(), để thread chính chờ 2 thread hoàn thành
//và tiếp tục chạy ex: thread1.join()
// thread chính sẽ chờ thread1 thực thi xong hàm run()của thread1.
// Thì thread chính mới chạy tiếp
public class Main {
    public static void main(String[] args) {
        SumThread thread1 = new SumThread(1,5);
        SumThread thread2 = new SumThread(6,10);
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        int totalSum = thread1.getResult() + thread2.getResult();
        System.out.println("Tổng tâ cả các số từ 1 đến 10 : " + totalSum);
    }
}
