package buoi4.btvn;

import java.util.*;

public class Bai3 {
    public static int soLuongPhanTu = 0;
    public static int giaTriMoRongMacDinh = 10;

    public static void main(String[] args) {
        int[] array = {7, 5, 4, 2, 4, 5, 8};
        soLuongPhanTu = array.length;
        hienThi(array);
        boolean tiepTuc = true;
        do {
            System.out.println("\nNhap vao cac chuc nang muon su dung: ");
            System.out.println("2. Tính tổng các phần tử chẵn và tổng các phần tử lẻ trong mảng.");
            System.out.println("3. Tìm và in ra các số nguyên tố có trong mảng.");
            System.out.println("4. Sắp xếp mảng");
            System.out.println("5. Chia mảng thành 2 mảng con");
            System.out.println("6. Tìm số lượng phần tử trùng lặp trong mảng và in ra các phần tử trùng lặp.");
            System.out.println("7. Thêm một phần tử vào mảng:");
            System.out.println("8. Xoá một phần tử khỏi mảng:");
            System.out.println("9. Thoat! ");
            int luaChon = new Scanner(System.in).nextInt();
            switch (luaChon) {
                case 2:
                    tinhTong(array);
                    break;
                case 3:
                    hienThiSoNguyenTo(array);
                    break;
                case 4:
                    sapXepMang(array);
                    break;
                case 5:
                    chiaMang(array);
                    break;
                case 6:
                    timPhanTuTrungLap(array);
                    break;
                case 7:
                    themPhanTu(array);
                    break;
                case 8:
                    xoaPhanTu(array);
                    break;
                case 9:
                    System.out.println("Thoat chuong trinh !");
                    tiepTuc = false;


            }
        } while (tiepTuc);
    }

    public static void xoaPhanTu(int[] array) {
        System.out.println("Nhap vao phan tu muon xoa: ");
        int data = new Scanner(System.in).nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == data) {
                for (int j = i; j < soLuongPhanTu; j++) {
                    if (j != soLuongPhanTu - 1) {
                        array[j] = array[j + 1];
                    }
                }
                soLuongPhanTu--;
            }
        }
        hienThi(array);
    }

    public static void themPhanTu(int[] arr) {
        System.out.println("\nNhap vao vi tri muon them bat dau tu 1: ");
        int index = new Scanner(System.in).nextInt();
        index = index - 1;
        System.out.println("Nhap vao du lieu muon thme: ");
        int data = new Scanner(System.in).nextInt();
        if (index >= arr.length) {
            System.out.println("Index khong hop le, index can nho hon: " + arr.length);
            return;
        }
        if (soLuongPhanTu >= arr.length) {
            int[] arrCopy = arr;
            arr = new int[arr.length + giaTriMoRongMacDinh];
            for (int i = 0; i < soLuongPhanTu; i++) {
                arr[i] = arrCopy[i];
            }
        }
        themPhanTuVaoIndex(arr, index, data);
        hienThi(arr);
    }

    public static void themPhanTuVaoIndex(int[] arr, int index, int data) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = data;
        soLuongPhanTu++;
    }

    public static void timPhanTuTrungLap(int[] array) {
        System.out.println("Cac phan tu trung lap la: ");
        for (int i = 0; i < soLuongPhanTu; i++) {
            int ptu = array[i];
            boolean phanTuDuocKiemTra = false;
            for (int j = 0; j < i; j++) {
                if (array[j] == ptu) {
                    phanTuDuocKiemTra = true;
                }
            }
            if (phanTuDuocKiemTra) {
                continue;
            }
            int count = 0;
            for (int j = i; j < soLuongPhanTu; j++) {
                if (array[j] != ptu) {
                    continue;
                }
                count++;
            }
            if (count >= 2) {
                System.out.println(ptu + " ");
            }
        }
    }

    public static void chiaMang(int[] array) {
        int mid = array.length / 2;
        int[] mangDau = Arrays.copyOfRange(array, 0, mid);
        int[] mangCuoi = Arrays.copyOfRange(array, mid, array.length);
        System.out.println("Mảng con thứ nhất: " + Arrays.toString(mangDau));
        System.out.println("Mảng con thứ hai: " + Arrays.toString(mangCuoi));
    }

    public static void sapXepMang(int[] array) {
        for (int i = 0; i < soLuongPhanTu; i++) {
            if (array[i] % 2 == 0) {
                for (int j = i + 1; j < soLuongPhanTu; j++) {
                    if (array[j] % 2 != 0 || array[i] > array[j]) {
                        continue;
                    }
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            } else {
                for (int j = i + 1; j < soLuongPhanTu; j++) {
                    if (array[j] % 2 == 0 || array[i] < array[j]) {
                        continue;

                    }
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                }
            }
        }
        hienThi(array);
    }

    public static void hienThiSoNguyenTo(int[] arr) {
        System.out.println("Danh sach cac so nguyen to: ");
        for (int i = 0; i < soLuongPhanTu; i++) {
            if (!laSoNguyenTo(i)) {
                continue;
            }
            System.out.println(arr[i] + " ");
        }
    }

    public static boolean laSoNguyenTo(int data) {
        if (data == 1) {
            return true;
        }
        for (int i = 2; i < Math.sqrt(data); i++) {
            if (data % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void tinhTong(int[] arr) {
        int tongChan = 0;
        int tongLe = 0;
        for (int i = 0; i < soLuongPhanTu; i++) {
            if (arr[i] % 2 == 0) {
                tongChan += arr[i];
            }
            tongLe = +arr[i];
        }
        System.out.println("Tong chan: " + tongChan);
        System.out.println("Tong le: " + tongLe);

    }

    public static void hienThi(int[] arr) {
        System.out.println("\n- Danh sach cac phan tu cua mang: ");
        for (int i = 0; i < soLuongPhanTu; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}