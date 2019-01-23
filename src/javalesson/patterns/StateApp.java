package javalesson.patterns;

public class StateApp {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.setLight(new RedLight());
        for (int i = 0; i < 10; i++) {
            trafficLight.lightAndSwitch();
        }
    }
}

class TrafficLight{
    private Light light;

    void setLight(Light light) {
        this.light = light;
    }
    void lightAndSwitch(){
        light.light(this);
    }
}
interface Light{
    void light(TrafficLight trafficLight);
}
class RedLight implements Light{

    @Override
    public void light(TrafficLight trafficLight) {
        System.out.println("RED LIGHT");
        trafficLight.setLight(new YellowLight());
    }
}
class YellowLight implements Light{

    @Override
    public void light(TrafficLight trafficLight) {
        System.out.println("YELLOW LIGHT");
        trafficLight.setLight(new GreenLight());
    }
}
class GreenLight implements Light{

    @Override
    public void light(TrafficLight trafficLight) {
        System.out.println("GREEN LIGHT");
        trafficLight.setLight(new RedLight());
    }
}


//public class StateApp {
//    public static void main(String[] args) {
//        Human human = new Human();
//        human.setState(new Work());
//        for (int i = 0; i < 10; i++) {
//            human.doSomething();
//        }
//
//    }
//}
//
//class Human{
//    private Activity state;
//
//    public void setState(Activity state) {
//        this.state = state;
//    }
//
//    public void doSomething(){
//        state.doSomething(this);
//    }
//}
//interface Activity{
//    void doSomething(Human context);
//}
//class Work implements Activity{
//
//    @Override
//    public void doSomething(Human context) {
//        System.out.println("Работаем...");
//        context.setState(new WeekEnd());
//    }
//}
//class WeekEnd implements Activity{
//
//    @Override
//    public void doSomething(Human context) {
//        System.out.println("Отдыхаем...");
//        context.setState(new Work());
//    }
//}


//public class StateApp {
//    public static void main(String[] args) {
//        Radio radio = new Radio();
//        radio.setStation(new RadioRock());
//        for (int i = 0; i < 10; i++) {
//            radio.play();
//            radio.nextStation();
//        }
//    }
//}
//interface Station{
//    void play();
//}
//class RadioRock implements Station{
//
//    @Override
//    public void play() {
//        System.out.println("RadioRock");
//    }
//}
//class RadioNashe implements Station{
//
//    @Override
//    public void play() {
//        System.out.println("Nashe Radio");
//    }
//}
//class Radio107Fm implements Station{
//
//    @Override
//    public void play() {
//        System.out.println("Radio 107 FM");
//    }
//}
//class Radio{
//    private Station station;
//
//    void setStation(Station station) {
//        this.station = station;
//    }
//    void nextStation(){
//        if(station instanceof RadioRock){
//            setStation(new RadioNashe());
//        } else if(station instanceof RadioNashe){
//            setStation(new Radio107Fm());
//        } else if(station instanceof Radio107Fm){
//            setStation(new RadioRock());
//        }
//    }
//    void play(){
//        station.play();
//    }
//}