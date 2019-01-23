package javalesson.patternsgof.behavioral;

import java.util.ArrayList;
import java.util.List;

public class Observer1Lesson {
    public static void main(String[] args) {
        JavaDeveloperWebSite webSite = new JavaDeveloperWebSite();
        webSite.addVacancy("First Java Position");
        webSite.addVacancy("Second Java Position");
        Observer firstSubscriber = new Subscriber("Vasia");
        Observer secondSubscriber = new Subscriber("Petia");
        webSite.addObserver(firstSubscriber);
        webSite.addObserver(secondSubscriber);
        webSite.addVacancy("Third Java Position");
        Observer therdSubscriber = new Subscriber("Dima");
        webSite.addObserver(therdSubscriber);
        webSite.removeVacancy("First Java Position");
        webSite.removeObserver(firstSubscriber);
        webSite.removeVacancy("Second Java Position");


    }
}
interface Observer{
    void handleEvent(List<String> vacancies);
}
interface Observed{
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
class Subscriber implements Observer{
    String name;
    public Subscriber(String name) {
        this.name = name;
    }
    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Dear " + name + "\nWe have changes in vacancy: " + vacancies);
    }
}
class JavaDeveloperWebSite implements Observed{
    private List<String> vacancies = new ArrayList<>();
    private List<Observer> subscribers = new ArrayList<>();

    public void addVacancy(String vacancy) {
        this.vacancies.add(vacancy);
        notifyObservers();
    }
    public void removeVacancy(String vacancy) {
        this.vacancies.remove(vacancy);
        notifyObservers();
    }
    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer :  subscribers){
            observer.handleEvent(this.vacancies);
        }
    }
}
