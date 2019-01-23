package javalesson.patternsgof.behavioral;

public class State3Lesson {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.setState(new RedLight());
        for (int i = 0; i < 10; i++) {
            trafficLight.light();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class TrafficLight{
    ActivityS state;

    public void setState(ActivityS state) {
        this.state = state;
    }
    void light(){
        state.light(this);
    }
}
interface ActivityS{
    void light(TrafficLight trafficLight);
}
class RedLight implements ActivityS{

    @Override
    public void light(TrafficLight trafficLight) {
        System.out.println("RED LIGHT");
        trafficLight.setState(new YellowLight());
    }
}
class YellowLight implements ActivityS{

    @Override
    public void light(TrafficLight trafficLight) {
        System.out.println("YELLOW LIGHT");
        trafficLight.setState(new GreenLight());
    }
}
class GreenLight implements ActivityS{

    @Override
    public void light(TrafficLight trafficLight) {
        System.out.println("GREEN LIGHT");
        trafficLight.setState(new RedLight());
    }
}