package buoi6.theGioiDongVat;

public class Monkey extends Animal {
    public Monkey(String ten, String tuoi){
        super(ten, tuoi);
    }
    @Override
    public void makeSound() {
        System.out.println("Monkey is chattering.");
    }
    public void action(){
        System.out.println("The monkey is climbing trees.");
    }
}
