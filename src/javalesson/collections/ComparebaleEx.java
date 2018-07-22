package javalesson.collections;

import java.util.*;
import java.util.stream.Collectors;

public class ComparebaleEx {
    public static void main(String[] args) {
        Set<MyPerson> list = new TreeSet<>();
        list = new TreeSet<>(new ComparePerson());
        list.add(new MyPerson(5));
        list.add(new MyPerson(10));
        list.add(new MyPerson(8));
        list.add(new MyPerson(3));
        list.add(new MyPerson(6));
        System.out.println(list);
        list.stream().sorted(new ComparePerson()).forEach(x -> System.out.println(x));
        list.stream().forEach(x -> System.out.println(x));

        List<Integer> myList = Arrays.asList(1, 5, 9, 7, 3, 65, 4, 2);
        Collections.sort(myList);
        System.out.println(myList);
    }
}

class ComparePerson implements Comparator<MyPerson> {

    @Override
    public int compare(MyPerson o1, MyPerson o2) {
        return o1.getAge() - o2.getAge();
    }
}

class MyPerson implements Comparable<MyPerson> {
    private int age;
    private String name;

    public MyPerson(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "age=" + age +
                '}';
    }


    @Override
    public int compareTo(MyPerson o) {
        return this.name.compareTo(o.name);
    }
}

