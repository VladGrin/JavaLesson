package javalesson.stepic;

import java.util.stream.IntStream;

public class StreamTask1 {
    public static void main(String[] args) {
        pseudoRandomStream(13).limit(20).forEach(System.out::println);
    }
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }
}
