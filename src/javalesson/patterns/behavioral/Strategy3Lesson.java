package javalesson.patterns.behavioral;

public class Strategy3Lesson {
    public static void main(String[] args) {
        TrafficLight1 trafficLight1 = new TrafficLight1();
        trafficLight1.setLightStrategy(new RedLight1());
        trafficLight1.execute(2000);
        trafficLight1.setLightStrategy(new YellowLight1());
        trafficLight1.execute(500);
        trafficLight1.setLightStrategy(new GreenLight1());
        trafficLight1.execute(1000);
    }
}
class TrafficLight1{
    LightStrategy lightStrategy;

    public void setLightStrategy(LightStrategy lightStrategy) {
        this.lightStrategy = lightStrategy;
    }

    void execute(int time){
        lightStrategy.light(time);
    }
}
interface LightStrategy{
    void light(int time);
}
class RedLight1 implements LightStrategy{

    @Override
    public void light(int time) {
        System.out.println("RED LIGHT");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class YellowLight1 implements LightStrategy{

    @Override
    public void light(int time) {
        System.out.println("Yellow LIGHT");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class GreenLight1 implements LightStrategy{

    @Override
    public void light(int time) {
        System.out.println("Green LIGHT");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

