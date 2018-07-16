package javalesson.streams;

import java.sql.Connection;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {

        Stream.builder().add(25).add(0).add(30).build().sorted().forEach(x-> System.out.println(x));
    }
}
