package javalesson.patterns.creational;

public class FactoryMethodLesson {
    public static void main(String[] args) {
        Person person = Person.create();
        Tank tank = Tank.create();
        person.identif();
        tank.identif();
    }
}

class Person{
    private Person(){}
    public static Person create(){
        return new Person();
    }
    void identif(){
        System.out.println("Person");
    }
}
class Tank{
    private Tank() {
    }
    static Tank create(){
        return new Tank();
    }
    void identif(){
        System.out.println("Tank");
    }
}

