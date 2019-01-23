package javalesson.patterns;

public class Strategy {
    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setStrategy(new MultiplNumbers());
        double array[] = {1, 5, 5.3, 2.4};
        double execute = strategyClient.execute(array);
        System.out.println(execute);
    }
}
class StrategyClient{
    private Counter counter;
    void setStrategy(Counter counter){
        this.counter = counter;
    }
    public double execute(double ... array){
        return counter.getResult(array);
    }
}
interface Counter{
    double getResult(double ... array);
}
class SumNumbers implements Counter{

    @Override
    public double getResult(double... array) {
        double result = 0;
        for(double number : array){
            result += number;
        }
        return result;
    }
}
class MultiplNumbers implements Counter{

    @Override
    public double getResult(double... array) {
        double result = 1.0;
        for(double number : array){
            result *= number;
        }
        return result;
    }
}