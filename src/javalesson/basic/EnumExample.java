package javalesson.basic;

public class EnumExample {
    enum CoffeeSize{SMALL(100), MEDIUM(200),  BIG(300){
        String getCoffeeClass(){
            return "B";
        }
    };
        String coffeeClass = "A";
        int milliters;
        CoffeeSize(int milliters) {
            this.milliters = milliters;
        }
        int getMilliters(){
            return this.milliters;
        }
        String getCoffeeClass(){
            return coffeeClass;
        }
    }

    public static void main(String[] args) {
        CoffeeSize coffeeSize = CoffeeSize.BIG;
        System.out.println(coffeeSize);
        System.out.println(coffeeSize.getMilliters());
        System.out.println(coffeeSize.getCoffeeClass());
    }
}
class CoffeeSize2{
    public static final CoffeeSize2 SMALL = new CoffeeSize2();
    public static final CoffeeSize2 MEDIUM = new CoffeeSize2();
    public static final CoffeeSize2 BIG = new CoffeeSize2();
}
