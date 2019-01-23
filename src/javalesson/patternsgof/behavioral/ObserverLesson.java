package javalesson.patternsgof.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverLesson {
    public static void main(String[] args) {
        ObserverNew observerNew1 = new ObserverNew("One");
        ObserverNew observerNew2 = new ObserverNew("Two");
        ObserverNew observerNew3 = new ObserverNew("Three");
        observerNew1.setState("new State");
        observerNew2.setState("Hello");
        observerNew3.setState("LOL");
        observerNew2.setState("Why LOL?");
    }
}

class ObserverNew {
    static List<ObserverNew> observers = new ArrayList<>();
    String name;
    String state;

    public ObserverNew(String name) {
        this.name = name;
        observers.add(this);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (ObserverNew observerNew : observers){
            observerNew.upDate();
        }
    }

    private void upDate() {
        System.out.println(name + " change status : " + state);
    }
}