package javalesson.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamsExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        for (String s : list){
            System.out.println(s);
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Stream<String> stream = list.stream();
        list.stream().forEach(x -> System.out.println(x));
        list.stream().filter(x -> {
            System.out.println("Hello");
            return x.equals("one");
        }).count();
        Set<String> set = list.stream().filter(x -> x.equals("one")).collect(Collectors.toSet());
        set = list.stream().collect(Collectors.toSet());
        set.stream().forEach(x-> System.out.println(x));
        list.stream().map(x -> x.toUpperCase());
//        Stream.of("three", "four").flatMap()
        Stream.of(asList("1","2"), asList("3", "4")).flatMap(x -> x.stream()).forEach(x -> System.out.println(x));
        int value1 = Stream.of(1, 5).min(Comparator.comparing(x -> x)).get();
        int value2 = Stream.of(1, 5).max(Comparator.comparing(x -> x)).get();
        System.out.println(value1 + " " + value2);
        int value3 = Stream.of(1,2,3,4,5).reduce(100,(acc, elem) -> acc + elem);
        System.out.println(value3);
        Person person = Stream.of(new Person.Builder().setName("Cat").setAge(20).built(),
                new Person.Builder().setName("Ann").setAge(25).built(),
                new Person.Builder().setName("Met").setAge(18).built()).max(Comparator.comparing(x -> x.getName())).get();
        System.out.println(person);
        List<Integer> list1 = Stream.of(4,2,6,3,1,5).sorted().collect(Collectors.toList());
        System.out.println(list1);
        List<Integer> list2 = Stream.of(1,2,3,4,5).limit(2).collect(Collectors.toList());
        System.out.println(list2);
        List<Integer> list3 = Stream.of(1,2,3,4,2).distinct().collect(Collectors.toList());
        System.out.println(list3);
        List<Integer> list4 = Stream.of(1,2,3,4,5).skip(2).collect(Collectors.toList());
        System.out.println(list4);
        int rez = Stream.of(1,2,3,4).mapToInt(num -> num).sum();
        System.out.println(rez);
        IntStream stream1 = Stream.of(1,2,3,4).mapToInt(x -> x);
        System.out.println(stream1.summaryStatistics().getAverage());
        //lazy // eager
    }
}
class Person{
    private String name;
    private int age;

    private Person(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    @Override
    public String toString(){
        return "Name " + name + ", Age " + age;
    }
    public static class Builder{
        private String name = "Bob";;
        private int age = 100;
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setAge(int age){
            this.age = age;
            return this;
        }
        public Person built(){
            return new Person(this);
        }

    }
}
