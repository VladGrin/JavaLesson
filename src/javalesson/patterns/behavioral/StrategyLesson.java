package javalesson.patterns.behavioral;

public class StrategyLesson {
    public static void main(String[] args) {
        double startPrice = 100;
        ContextStrategy context = new ContextStrategy();
        context.setStrategy(new FullPrice());
        double price = context.getPrice(startPrice);
        System.out.println(price);
        context.setStrategy(new HalfPrice());
        price = context.getPrice(startPrice);
        System.out.println(price);
    }
}
interface Strategy{
    double getPrice(double price);
}
class FullPrice implements Strategy{

    @Override
    public double getPrice(double price) {
        return price;
    }
}
class HalfPrice implements Strategy{

    @Override
    public double getPrice(double price) {
        return price*0.5;
    }
}
class ContextStrategy{
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price) {
        return strategy.getPrice(price);
    }
}