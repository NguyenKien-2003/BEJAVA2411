package buoi6.theGioiDongVat;

/**
 * Bài tập 1: Áp dụng tính kế thừa Đề bài: Xây dựng chương trình quản lý động vật trong sở thú:
 * 1. Tạo lớp cha Animal với các thuộc tính và phương thức:
 * • Thuộc tính:
 * name (tên động vật),
 * age (tuổi).
 * • Phương thức:
 * method:
 * eat() (in ra “Animal is eating”).
 * 2. Tạo các lớp con:
 * • Lion: có phương thức riêng roar() (in ra “Lion is roaring”).
 * • Elephant: có phương thức riêng trumpet() (in ra “Elephant is trumpeting”).
 * 3. Tạo đối tượng Lion và Elephant, gọi các phương thức chung (eat())
 * và phương thức riêng (roar(), trumpet()) của chúng.
 * Bài tập 2: Áp dụng tính kế thừa với lớp trừu tượng và ghi đè
 * Đề bài:Phát triển chương trình quản lý động vật trong sở thú từ bài tập 1:
 * 1. Chuyển lớp cha Animal thành lớp trừu tượng.
 * 2. Thêm phương thức trừu tượng makeSound() trong Animal.
 * 3. Ghi đè phương thức makeSound() ở các lớp con (Lion, Elephant) với nội dung:
 * • Lion: “Lion is roaring.”
 * • Elephant: “Elephant is trumpeting.”
 * 4. Thêm lớp Monkey kế thừa từ Animal, phương thức makeSound() in ra “Monkey is chattering.”
 * 5. Tạo một danh sách chứa các đối tượng Lion, Elephant, và Monkey, sau đó duyệt qua danh sách
 * và gọi phương thức makeSound() cho từng đối tượng.
 */
public abstract class Animal {
    public String ten;
    public String tuoi;
public Animal(String ten, String tuoi) {
    this.ten = ten;
    this.tuoi = tuoi;
}
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public void eat(){
        System.out.println("Animal is eating...");
    }
    public abstract void makeSound();
    public abstract void action();
    public void showInfo(){
        System.out.println("Ten: " +ten);
        System.out.println("Tuoi: " +tuoi);

    }
}
