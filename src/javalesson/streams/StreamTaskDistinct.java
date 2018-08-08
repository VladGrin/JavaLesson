package javalesson.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTaskDistinct {
    public static void main(String[] args) {
        Collection<String> ordered = Arrays.asList("b3", "a3", "a1", "a3", "a2", "a2", "a3", "a1", "a2", "a2", "a3");
        Collection nonOrdered = new HashSet<>(ordered);
        System.out.println(ordered);
        System.out.println(nonOrdered);

        List<String> integerList = (List<String>) nonOrdered.stream().distinct().collect(Collectors.toList());
        System.out.println(integerList);

        List<String> nonOrderIntegerList = ordered.stream().distinct().collect(Collectors.toList());
        System.out.println(nonOrderIntegerList);

    }
}
