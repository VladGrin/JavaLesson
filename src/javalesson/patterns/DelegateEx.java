package javalesson.patterns;

public class DelegateEx {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.setCooker(new MeatCooker());
        waiter.service();
        waiter.setCooker(new SaladCooker());
        waiter.service();
        waiter.setCooker(new CakeCooker());
        waiter.service();
    }
}
class Waiter{
    private Cooker cooker;

    public void setCooker(Cooker cooker) {
        this.cooker = cooker;
    }

    void service(){
        cooker.cookFood();
    }
}
interface Cooker{
    void cookFood();
}
class CakeCooker implements Cooker{

    @Override
    public void cookFood() {
        System.out.println("Cook cake");
    }
}
class MeatCooker implements Cooker{

    @Override
    public void cookFood() {
        System.out.println("Cook meat");
    }
}
class SaladCooker implements Cooker{

    @Override
    public void cookFood() {
        System.out.println("Cook salad");
    }
}