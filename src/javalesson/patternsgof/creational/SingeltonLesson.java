package javalesson.patternsgof.creational;

public class SingeltonLesson {
    public static void main(String[] args) {
        Singelton singelton = Singelton.getInstance();
        Singelton singelton1 = Singelton.getInstance();
        singelton.i = 5;
        System.out.println(singelton1.i);

        Singl singl = Singl.getInstance();
        singl.method();
        singl.method();
        singl.method();
    }
}

class Singelton {
    int i = 0;
    static Singelton singelton = new Singelton();
    private Singelton() {

    }

    public static Singelton getInstance() {
        return singelton;
    }
}

class Singl{
    private int i = 0;
    private static Singl singl = new Singl();
    private Singl() {
    }
    public static Singl getInstance(){
        return singl;
    }
    void method(){
        System.out.println(i++);
    }
}
