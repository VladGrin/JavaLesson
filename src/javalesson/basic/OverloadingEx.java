package javalesson.basic;

public class OverloadingEx {
    public static void main(String[] args) {
        OverloadingEx overloadingEx = new OverloadingEx();
        short b = 5;
        overloadingEx.metod(b);
    }

    void metod(int i){
        System.out.println("int");
    }
    void metod(long i){
        System.out.println("long");
    }
    void metod(Integer i){
        System.out.println("Integer");
    }
    void metod(double i){
        System.out.println("double");
    }
    void metod(Short... i){
        System.out.println("Short...");
    }
    void metod(short... i){
        System.out.println("short...");
    }
    void metod(Short i){
        System.out.println("Byte");
    }
    void metod(Object i){
        System.out.println("Object");
    }
    void metod(Object... i){
        System.out.println("Object...");
    }
    void metod(byte i){
        System.out.println("Byte");
    }
}
