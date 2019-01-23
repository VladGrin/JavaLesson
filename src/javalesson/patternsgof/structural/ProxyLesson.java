package javalesson.patternsgof.structural;

public class ProxyLesson {
    public static void main(String[] args) {
        CarI carI = new ProxyCar();
        carI.drive();
    }
}
interface CarI{
    void drive();
}
class Renault implements CarI{

    @Override
    public void drive() {
        System.out.println("Drive Renault");
    }
}
class ProxyCar implements CarI{
    CarI carI = new Renault();
    @Override
    public void drive() {
        System.out.println("Proxy code");
        carI.drive();
    }
}