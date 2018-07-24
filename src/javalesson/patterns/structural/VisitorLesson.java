package javalesson.patterns.structural;

public class VisitorLesson {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.doSomething(new ConcreatVisitor());
        Animal cat = new Cat();
        cat.doSomething(new ConcreatVisitor());
    }
}
interface Animal{
    void doSomething(Visitor visitor);
}
class Dog implements Animal{
    @Override
    public void doSomething(Visitor visitor) {
        visitor.doDog();
    }
}
class Cat implements Animal{
    @Override
    public void doSomething(Visitor visitor) {
        visitor.doCat();
    }
}
interface Visitor{
    void doDog();
    void doCat();
}
class ConcreatVisitor implements Visitor{

    @Override
    public void doDog() {
        System.out.println("I am dog");
        System.out.println("gav");
    }

    @Override
    public void doCat() {
        System.out.println("I am cat");
        System.out.println("miay");
    }
}