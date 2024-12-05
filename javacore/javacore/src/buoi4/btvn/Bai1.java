package buoi4.btvn;

import java.util.HashMap;
import java.util.Map;


public class Bai1 {
    public static void main(String[] args) {
        String str = "Tôi học lập trình, học lập trình rất hay";
        demSoLuongTu(str);



    }

    public  static void demSoLuongTu(String str){
        String[] arrStr = str.split(" ");
        xoaKyTuDacBiet(arrStr);
        int soDong = arrStr.length;
        int soCot = 2;
        int soLuongDongThucTe = 0;
        String[][] mangKetQua = new String[soDong][soCot];

        for(int i=0; i< arrStr.length; i++){
            boolean boQuaKyTu = false;
            String kyTuKiemTra = arrStr[i];

            for (int j=0;j<i;j++){
                if(kyTuKiemTra.equalsIgnoreCase(arrStr[j])){
                    boQuaKyTu = true;
                    break;
                }
            }
            if(boQuaKyTu){
                continue;
            }
            int count = 0;
            for (int j = i; j< arrStr.length; j++){
                if(kyTuKiemTra.equalsIgnoreCase(arrStr[j])){
                    count++;
                }
            }
            mangKetQua[soLuongDongThucTe][0] = kyTuKiemTra;
            mangKetQua[soLuongDongThucTe][1] = String.valueOf(count);
            soLuongDongThucTe++;
        }
        hienThiMangHaiChieu(mangKetQua,soLuongDongThucTe);

    }
    public static void hienThiMangHaiChieu(String[][] arr, int soDongThucTe){
        for(int i=0;i<soDongThucTe; i++){
            for (int j=0; j<arr[i].length; j++){
                String data = arr[i][j];
                if (j==0){
                    data = data.substring(0,1).toUpperCase() + data.substring(1);
                    System.out.printf(data + ":");
                    continue;
                }
                System.out.printf(arr[i][j] + "từ");
            }
            System.out.println("");
        }
    }
    public static void xoaKyTuDacBiet(String[] arrStr){
        for(int i=0; i< arrStr.length;i++){
            String str = arrStr[i].replace(".","").replace(";","").replace(":","").replace(",","").trim();
            arrStr[i] = str;

        }
    }


}
