package buoi6.theGioiDongVat;


public class Main {
    public static void main(String[] args) {
        Animal[] animals= new Animal[3];
        Animal lion = new Lion("lion","18");
//        lion.setTen("lion");
//        lion.setTuoi("18");
        animals[0]=lion;
        Animal elephant = new Elephant("elephant","19");
//        elephant.setTen("elephant");
//        elephant.setTuoi("19");
        animals[1]=elephant;
        Animal monkey = new Monkey("monkey","20");
//        monkey.setTen("monkey");
//        monkey.setTuoi("20");
        animals[2]=monkey;
        for (int i=0; i<animals.length; i++){
           animals[i].makeSound();
           animals[i].showInfo();
        }


    }
}
