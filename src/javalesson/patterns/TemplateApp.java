package javalesson.patterns;

public class TemplateApp {
    public static void main(String[] args) {
        Templ first = new First();
        first.func();
        Templ second = new Second();
        second.func();
    }
}
abstract class Templ{
    void func(){
        System.out.println("1");
        differ();
        System.out.println("3");
        differ2();
    }
    abstract void differ();
    abstract void differ2();
}
class First extends Templ{
    @Override
    void differ() {
        System.out.println("2");
    }

    @Override
    void differ2() {
        System.out.println();
    }
}
class Second extends Templ{
    @Override
    void differ() {
        System.out.println("4");
    }

    @Override
    void differ2() {
        System.out.println("7");
    }
}