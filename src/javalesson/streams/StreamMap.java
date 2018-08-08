package javalesson.streams;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        Collection<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<String> collection2 = Arrays.asList("1,2,0", "4,5");

        List<String> list = collection1.stream().map(x->x+"_1").collect(Collectors.toList());
        list.stream().forEach(System.out::println);

        int[] elements = collection1.stream().mapToInt(x->Integer.parseInt(x.substring(1))).toArray();
        Arrays.stream(elements).forEach(System.out::println);

        String[] integer = collection2.stream().flatMap(x->Arrays.asList(x.split(",")).stream()).toArray(String[]::new);
        Arrays.stream(integer).forEach(System.out::println);

        int sum = collection2.stream().flatMapToInt(x->Arrays.asList(x.split(",")).stream().mapToInt(Integer::parseInt)).sum();
        System.out.println(sum);
    }
}
