package javalesson.collections;

import java.util.*;

public class ListEx {
    public static void main(String[] args) {
        List<Car> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        List<String> stack = new Stack<>();
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        arrayList.add(new Car("Mers"));
        arrayList.add(new Car("BMV"));
        arrayList.add(new Car("AUDI"));
        for(Car s : arrayList){
            System.out.println(s);
        }
        Collections.sort(arrayList);
        for(Car s : arrayList){
            System.out.println(s);
        }

    }

}
class Car implements Comparable{
    String name;
    public Car(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Car)o).name);
    }
}