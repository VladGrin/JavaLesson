package javalesson.stepic;

import java.util.function.DoubleUnaryOperator;

public class Integral {
    public static void main(String[] args) {
        System.out.println(integrate(x -> x*x*x, 0, 1));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double rez = 0.0;
        double step = 0.000001;
        for (double i = a; i <= b; i += step) {
            rez += f.applyAsDouble(i)*step;
        }
        return rez;
    }
}
