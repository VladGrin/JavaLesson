package javalesson.patterns;

public class SingeltonLesson {
    public static void main(String[] args) {
        Singelton singelton = Singelton.getInstance();
        Singelton singelton1 = Singelton.getInstance();
        singelton.i = 5;
        System.out.println(singelton1.i);
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