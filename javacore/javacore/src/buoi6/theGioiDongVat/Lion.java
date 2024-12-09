package buoi6.theGioiDongVat;

public class Lion extends Animal{
    public Lion(String ten, String tuoi){
        super(ten, tuoi);
    }
    public void roar(){
        System.out.println("Lion is roaring");
    }
    @Override
    public void makeSound(){
        System.out.println("Lion is roaring.");
    }

    @Override
    public void action() {
        System.out.println("Lion is hunting.");
    }
}
