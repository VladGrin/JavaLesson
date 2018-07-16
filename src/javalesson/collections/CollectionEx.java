package javalesson.collections;

import java.util.*;

public class CollectionEx {
    public static void main(String[] args) {
        Collection<Integer> collection;
        List<String> list;
        Set<String> set;
        Queue<String> queue;

        Map<String, String> map;

        Integer l = 5;
        Integer a;
        String k;

        Person person = new Person();
        try {
            Object as = person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(person.toString());
    }
}
class Person implements Cloneable{
    String s;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
