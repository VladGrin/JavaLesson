package javalesson.stepic;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        Set<Integer> set3 = new HashSet<>();
        set3 = symmetricDifference(set1, set2);
        System.out.println(set3);
    }
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set3 = new HashSet<>(set1);
        Set<T> set4 = new HashSet<>(set2);
        set3.removeAll(set2);
        set4.removeAll(set1);
        set3.addAll(set4);
        return set3;
    }
}
