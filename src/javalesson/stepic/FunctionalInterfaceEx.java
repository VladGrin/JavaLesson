package javalesson.stepic;

import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjDoubleConsumer;

public class FunctionalInterfaceEx {
    public static void main(String[] args) {

        IntUnaryOperator square = x -> {
            return x*x;
        };
        System.out.println(square.applyAsInt(20));
        IntConsumer print = x -> System.out.println(x);
        print.accept(25);
        IntUnaryOperator cube = x->x*x*x;
        System.out.println(cube.applyAsInt(35));

        ObjDoubleConsumer<String> stringObjDoubleConsumer = (s, value) -> {
            System.out.println(s + value);
        };
        stringObjDoubleConsumer.accept("Number : ", 2.36);
    }
}
