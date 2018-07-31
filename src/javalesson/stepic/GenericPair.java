package javalesson.stepic;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;

public class GenericPair {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(i);
        System.out.println(s);
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }
}
class Pair<T,N> {
    private T value1;
    private N value2;
    private Pair(T value1, N value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    public static <T,N> Pair<T,N> of(T value1, N value2){
        return new Pair<>(value1, value2);
    }
    public T getFirst(){
        return this.value1;
    }
    public N getSecond(){
        return this.value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<T, N> pair = (Pair<T, N>) o;
        return Objects.equals(value1, pair.value1) &&
                Objects.equals(value2, pair.value2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2);
    }

    // вариант 1
    public void ifPresent1(BiConsumer<T, N> consumer) {
        System.out.println(1);
    }

    // вариант 2
    public void ifPresent2(BiConsumer<? super T, ? super N> consumer) {
        System.out.println(2);
    }

    // вариант 3
    public void ifPresent3(BiConsumer<? extends T, ? extends N> consumer) {
        System.out.println(3);
    }

    // вариант 4
    public void ifPresent4(BiConsumer<?, ?> consumer) {
        System.out.println(4);
    }

    // вариант 5
    public <X, Y> void ifPresent(BiConsumer<X, Y> consumer) {
        System.out.println(5);
    }
}
