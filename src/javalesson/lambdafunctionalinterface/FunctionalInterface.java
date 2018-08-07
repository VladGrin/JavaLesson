package javalesson.lambdafunctionalinterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FunctionalInterface {
    public static void main(String[] args) {
        Map<Integer, String> arr = new HashMap<>();
        arr.put(1, "Ded");
        arr.put(5, "Bon");
        arr.put(3, "Nil");
        for (Map.Entry<Integer, String> integerStringEntry : arr.entrySet()) {
            System.out.println(integerStringEntry.getKey() + " " + integerStringEntry.getValue());
        }
        Stream<Map.Entry<Integer, String>> entryStream = arr.entrySet().stream();
        entryStream.forEach(System.out::println);
        Stream.iterate(10, x -> x + 10).limit(10).forEach(System.out::println);

    }
}