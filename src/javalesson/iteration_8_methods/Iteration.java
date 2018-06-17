package javalesson.iteration_8_methods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iteration {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(i);
        }
        // First
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        // Second
        for (int x : list) {
            System.out.print(x + " ");
        }
        System.out.println();
        //Third
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        //  Fourth
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        //  Fifth
        list.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        //  Sixth
        list.stream().forEach(Iteration::printItemList);
        System.out.println();
        //  Seventh
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();
        //  Eighth
        list.forEach(Iteration::printItemList);
    }
    private static void printItemList(int x) {
        System.out.print(x + " ");
    }
}
