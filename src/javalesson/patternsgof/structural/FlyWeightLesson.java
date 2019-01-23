package javalesson.patternsgof.structural;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightLesson {
    public static void main(String[] args) {
        FlyWeightF flyWeightF = new FlyWeightF();
        Mers mers = flyWeightF.getMers("green");
        System.out.println(mers);
        Mers mers1 = flyWeightF.getMers("green");
        System.out.println(mers1);
        Mers mers2 = flyWeightF.getMers("red");
        System.out.println(mers2);
    }
}
class Mers{
    String color;
    @Override
    public String toString() {
        return "Mers{" +
                "color='" + color + '\'' +
                '}';
    }
}
class FlyWeightF{
    private static final Map<String, Mers> mersMap = new HashMap<>();
    public Mers getMers(String color){
        Mers mers = mersMap.get(color);
        if (mers == null){
            mers = new Mers();
            mers.color = color;
            mersMap.put(color, mers);
        }
        return mers;
    }
}