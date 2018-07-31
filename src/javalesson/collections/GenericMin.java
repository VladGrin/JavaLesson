package javalesson.collections;

import java.time.DayOfWeek;

public class GenericMin {
    public static void main(String[] args) {
        Integer[] array = {0,5,9,7,8,6,3,4,8,5,7,-25};
        System.out.println(getMinElement(array));
        Example<?> example = new Example<>();
        example.get(null);
    }
    public static <T extends Comparable<T>> T getMinElement(T[] value){
        if (value.length == 0){
            return null;
        }
        T min = value[0];
        for (int i = 1; i < value.length; i++) {
            if(value[i].compareTo(min) < 0){
                min = value[i];
            }
        }
        return min;
    }
}
class Example<X>{
    void get(X arg){
        System.out.println(arg);
    }
}



