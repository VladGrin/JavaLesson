package javalesson.patternsgof.behavioral;

public class Strategy2Lesson {
    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setStrategy(new Sum());
        strategyClient.executrStrategy(10, 20);
        strategyClient.setStrategy(new Dif());
        strategyClient.executrStrategy(30,20);
    }
}
class StrategyClient{
    Counting strategy;
    public void setStrategy(Counting strategy) {
        this.strategy = strategy;
    }
    public void executrStrategy(int a, int b){
        strategy.count(a, b);
    }
}
interface Counting{
    void count(int a, int b);
}
class Sum implements Counting{

    @Override
    public void count(int a, int b) {
        System.out.println(a+b);
    }
}
class Dif implements Counting{

    @Override
    public void count(int a, int b) {
        System.out.println(a-b);
    }
}