package javalesson.patterns.behavioral;

import com.sun.org.apache.xpath.internal.operations.Or;

public class MementoLesson {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("one");
        System.out.println(originator.getState());
        CareTacker careTacker = new CareTacker();
        careTacker.setMomento(originator.create());
        originator.setState("two");
        System.out.println(originator.getState());
        originator.getDataFromMomento(careTacker.getMomento());
        System.out.println(originator.getState());
    }
}
class CareTacker{
    public Momento getMomento() {
        return momento;
    }

    public void setMomento(Momento momento) {
        this.momento = momento;
    }

    private Momento momento;
}
class Originator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    Momento create(){
        return new Momento(state);
    }
    void getDataFromMomento(Momento momento){
        this.state = momento.getState();
    }
}
class Momento{
    private String state;

    public Momento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
