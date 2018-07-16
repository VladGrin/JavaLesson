package javalesson.basic;

public class InitializationEx {
    static int i = 10;
    int anInt = 20;
    static {
        System.out.println("static init");
        i = 35;
    }
    {
        System.out.println("init");
        System.out.println(i++);
    }
    InitializationEx(){
        System.out.println("Constr");
    }

    public static void main(String[] args) {
        System.out.println(InitializationEx.i);
        InitializationEx initializationEx1 = new InitializationEx();
        initializationEx1.anInt = 5;
        System.out.println(initializationEx1.anInt);
        InitializationEx initializationEx2 = new InitializationEx();
        InitializationEx initializationEx3 = new InitializationEx();
        InitializationEx initializationEx4 = new InitializationEx();
        InitializationEx initializationEx5 = new InitializationEx();
    }
}
