package buoi4;

//Cách xử lý với mảng
//
public class Main {
    public static void main(String[] args) {
        int[] mangCacSoNguyen = new int[10];
        String mangCacKyTu[] = new String[10];
        double[] mangCacSoTuNhien = {1,2,3,4,5};

        //them phan tu vao mang
        System.out.println( "Do dai cua mang: " +mangCacSoNguyen.length);
        mangCacKyTu[0] = "A";
        mangCacKyTu[1] = "B";
        mangCacKyTu[2] = "C";
        //lay phan tu ra
        // index = 1 và 3
        System.out.println(mangCacKyTu[1]);
        System.out.println(mangCacKyTu[3]);
        // duyệt tất cả các phần tử của mảng
        for(int index = 0; index < mangCacKyTu.length; index++){
            String duLieuMang = mangCacKyTu[index];
            System.out.println("" + duLieuMang);
        }

        for(int i = 0 ; i < mangCacSoNguyen.length; i++){

        }
    }
}
