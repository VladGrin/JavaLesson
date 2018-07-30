package javalesson.stepic;

public class ExeptionTask1 {
    public static void main(String[] args) {
//        A a = new A();
        System.out.println("1");
        Object b = new Object();
        A a = (A) b;
        System.out.println("2");
    }
}
class A{

}
class B extends A{

}
