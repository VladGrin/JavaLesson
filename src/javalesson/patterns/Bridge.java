package javalesson.patterns;

public class Bridge {
    public static void main(String[] args) {
        TypeCar typeCar1 = new Sedan(new Mers());
        TypeCar typeCar2 = new Sedan(new BMW());
        typeCar1.showDetails();
        typeCar2.showDetails();
        typeCar1 = new HetchBack(new Mers());
        typeCar2 = new HetchBack(new BMW());
        typeCar1.showDetails();
        typeCar2.showDetails();
    }
}
abstract class TypeCar{
    public Make make;

    TypeCar(Make make) {
        this.make = make;
    }
    abstract void showType();
    void showDetails() {
        showType();
        make.create();
    }
}
class Sedan extends TypeCar{

    Sedan(Make make) {
        super(make);
    }

    @Override
    void showType() {
        System.out.println("SEDAN");
    }

}
class HetchBack extends TypeCar{

    HetchBack(Make make) {
        super(make);
    }

    @Override
    void showType() {
        System.out.println("HETCHBACK");
    }

}
interface Make{
    void create();
}
class Mers implements Make{
    @Override
    public void create() {
        System.out.println("Create Mers");
    }
}
class BMW implements Make{

    @Override
    public void create() {
        System.out.println("Create BMW");
    }
}