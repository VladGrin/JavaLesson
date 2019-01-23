package javalesson.patterns;

public class SingletonApp {
    public static void main(String[] args) {
        Singleton singleton;
        for (int i = 0; i < 1000; i++) {
            singleton = Singleton.getInstanse();
        }
        System.out.println(Singleton.counter);
    }
}
class Singleton{
    public static int counter = 0;
    private static Singleton instance;
    private Singleton() {
        counter++;
    }
    public static Singleton getInstanse(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}