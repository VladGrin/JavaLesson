package javalesson.stepic;
//Реализуйте метод sqrt(), вычисляющий квадратный корень числа.
// В отличие от Math.sqrt(), это метод при передаче отрицательного
// параметра должен бросать исключение java.lang.IllegalArgumentException
// с сообщением "Expected non-negative number, got ?",
// где вместо вопросика будет подставлено фактически переданное в метод число.

public class ExeptionTask2 {
    public static void main(String[] args) {
        System.out.println(sqrt(25));
        System.out.println(sqrt(-25));
    }

    public static double sqrt(double x) {
        if (x >= 0) {
            return Math.sqrt(x);
        } else {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
    }
}
