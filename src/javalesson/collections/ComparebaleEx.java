package javalesson.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparebaleEx {
    public static void main(String[] args) {
        Set<MyPerson> list = new TreeSet<>();
        list = new TreeSet<>(new ComparePerson());
        list.add(new MyPerson(5));
        list.add(new MyPerson(10));
        list.add(new MyPerson(8));
        list.add(new MyPerson(3));
        list.add(new MyPerson(6));
        System.out.println(list );
        list.stream().sorted().forEach(x-> System.out.println(x));
        list.stream().forEach(x-> System.out.println(x));


    }
}

class ComparePerson implements Comparator<MyPerson> {

    @Override
    public int compare(MyPerson o1, MyPerson o2) {
        return o1.getAge() - o2.getAge();
    }
}

class MyPerson implements Comparable<MyPerson>{
    private int age;

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
        return this.age - o.age;
    }
}

