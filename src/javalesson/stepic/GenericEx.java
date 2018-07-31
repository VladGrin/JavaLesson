package javalesson.stepic;

import javalesson.Ex;

import java.util.Optional;

public class GenericEx {
    public static void main(String[] args) {
        Example example = new Example();
        example.someMethod(1);
    }
}
class Example<X>{
    public void someMethod(Object obj){
        System.out.println(100);
//        System.out.println(obj instanceof X);
//        X[] ar = new X[5];
    }
}