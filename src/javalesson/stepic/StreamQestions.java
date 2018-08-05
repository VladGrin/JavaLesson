package javalesson.stepic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamQestions {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,5,9,2,584,66,6,65,1651,651,15,51,15,5,15,151};
        List<Integer> list = Arrays.asList(array);
        Set<Integer> set = new HashSet<>();
        list.stream().sorted().forEach(x-> System.out.print(x + " "));
        System.out.println();
        int sum = IntStream.iterate(1, n -> n+1)
                .filter(n -> n%5 == 0 && n%2 !=0)
                .limit(10)
                .map(n -> n*n)
                .sum();
        System.out.println(sum);
    }
}
