package javalesson.stepic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StreamTask3 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextLine());
        }
        list.stream().forEach(System.out::println
        );
    }
}
