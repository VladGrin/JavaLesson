package javalesson.patterns;

import java.io.File;

public class NullObject {
    public static void main(String[] args) {
        Animal animal = getAnimal();
        animal.eat();
    }
    static Animal getAnimal(){
        try{
            if(new File("adfas").exists()){
                return new Lion();
            }
        }finally {
//            return null;
            return new NoAnimal();
        }
    }
}
interface Animal{
    void eat();
}
class Lion implements Animal{

    @Override
    public void eat() {
        System.out.println("Lion eats...");
    }
}
class NoAnimal implements Animal{

    @Override
    public void eat() {
        System.out.println("No animal...");
    }
}