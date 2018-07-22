package javalesson.patterns.creational;

public class FactoryLesson1 {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Car mersedes = factory.create("Mersedes");
        Car chevrolet = factory.create("Chevrolet");
        mersedes.drive();
        chevrolet.drive();
    }
}

interface Car{
    void drive();
}
class Mersedes implements Car{
    @Override
    public void drive() {
        System.out.println("We have made Mersedes");
    }
}
class Chevrolet implements Car{
    @Override
    public void drive() {
        System.out.println("We have made Chevrolet");
    }
}
class Factory{
    public Car create(String string){
        switch (string){
            case "Mersedes" : return new Mersedes();
            case "Chevrolet" : return new Chevrolet();
            default: return null;
        }
    }
}