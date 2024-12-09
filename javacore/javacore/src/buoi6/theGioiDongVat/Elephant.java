package buoi6.theGioiDongVat;

public class Elephant extends Animal{
public Elephant(String ten, String tuoi) {
    super(ten, tuoi);
}
    public static void trumpet(){
        System.out.println("Elephant is trumpeting");
    }
    @Override
    public void makeSound() {
        System.out.println("Elephant is trumpeting.");
    }
    public void action(){
        System.out.println("The elephant is spraying water.");
    }
}
