package javalesson.streams;

import java.util.Arrays;
import java.util.List;

public class StreamMatch {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("b3", "a3", "a1", "a3", "a2", "a2", "a3", "a1", "a2", "a2", "a3");
        boolean b = list.stream().anyMatch("a1"::equals);
        System.out.println(b);
        b = list.stream().anyMatch("a8"::equals);
        System.out.println(b);
        b = list.stream().allMatch(x -> x.contains("1") || x.contains("2") || x.contains("3"));
        System.out.println(b);
        b = list.stream().noneMatch("a7"::equals);
        System.out.println(b);
    }
}
