package buoi6.theGioiDongVat;

import java.util.Scanner;

public class ManagerAnimal {
    private Animal[] animals;
    private int numberCurrentAnimal;

    public ManagerAnimal(int n) {
        this.animals = new Animal[n];
        this.numberCurrentAnimal = 0;
    }

    public void addAnimal(Animal animal) {
        if (numberCurrentAnimal == animals.length) {
            moRongDanhSach();
        }
        animals[numberCurrentAnimal++] = animal;
    }

    private void moRongDanhSach() {
        Animal[] newAnimals = new Animal[animals.length + 10];
        System.arraycopy(animals, 0, newAnimals, 0, animals.length);
        animals = newAnimals;
        System.out.println("Danh sách hiện tại có " + animals.length + "slot");
    }

    public void hienThiDanhSachDongVat() {
        if (numberCurrentAnimal == 0) {
            System.out.println("No animals in the zoo.");
            return;
        }
        for (int i = 0; i < numberCurrentAnimal; i++) {

            System.out.println("Tên: " + animals[i].ten + " Tuổi: " + animals[i].tuoi);
        }
    }

    public void searchAnimal(String ten) {
        for (int i = 0; i < numberCurrentAnimal; i++) {
            if (animals[i].getTen().equalsIgnoreCase(ten)) {
                System.out.println("Tên động vật cần tìm: " + animals[i].ten);
                System.out.println("Tuổi động vật cần tìm: " + animals[i].tuoi);
                return;
            }
        }
        System.out.println("Animal with name " + ten + " not found.");
    }

    public void removeAnimal(String ten) {
        for (int i = 0; i < numberCurrentAnimal; i++) {
            if (animals[i].getTen().equalsIgnoreCase(ten)) {
                for (int j = i; j < numberCurrentAnimal - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[--numberCurrentAnimal] = null;
                System.out.println("Động vật " + ten + " đã được xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy " + ten);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tổng số lượng thú: ");
        int n = sc.nextInt();
        sc.nextLine();
        boolean tiepTuc = true;
        ManagerAnimal manager = new ManagerAnimal(n);


        do {
            System.out.println("------------------------------");
            System.out.println("THẾ GIỚI ĐỘNG VẬT");
            System.out.println("1. Nhập vào Lion: ");
            System.out.println("2. Nhập vào Elephant: ");
            System.out.println("3. Nhập vào Monkey: ");
            System.out.println("4. Hiển thị dang sách các động vật");
            System.out.println("5. Tìm kiếm theo tên: ");
            System.out.println("6. Nhập vào Monkey: ");
            System.out.println("7. Thoát ! ");
            System.out.println("------------------------------");
            System.out.println("Nhập vào chức năng muốn sử dụng: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name of the Lion: ");
                    String lionName = sc.nextLine();
                    System.out.print("Enter age of the Lion: ");
                    String lionAge = sc.nextLine();
                    manager.addAnimal(new Lion(lionName, lionAge));

                    break;
                case 2:
                    System.out.print("Enter name of the Elephant: ");
                    String elephantName = sc.nextLine();
                    System.out.print("Enter age of the Elephant: ");
                    String elephantAge = sc.nextLine();
                    manager.addAnimal(new Elephant(elephantName, elephantAge));
                    break;
                case 3:
                    System.out.print("Enter name of the Monkey: ");
                    String monkeyName = sc.nextLine();
                    System.out.print("Enter age of the Monkey: ");
                    String monkeyAge = sc.nextLine();
                    manager.addAnimal(new Monkey(monkeyName, monkeyAge));
                    break;
                case 4:
                    manager.hienThiDanhSachDongVat();
                    break;
                case 5:
                    System.out.println("Nhập vào tên động vật muốn tìm: ");
                    String tenCanTim = sc.nextLine();
                    manager.searchAnimal(tenCanTim);
                    break;
                case 6:
                    System.out.println("Nhập vào tên động vật muốn xóa:");
                    String tenCanXoa = sc.nextLine();
                    manager.removeAnimal(tenCanXoa);
                    break;
                case 7:
                    tiepTuc = false;
                    break;


            }


        } while (tiepTuc == true);
    }

}
