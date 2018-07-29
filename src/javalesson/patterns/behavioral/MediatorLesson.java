package javalesson.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class MediatorLesson {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        Collegue collegue1 = new ConcretaCollegue(concreteMediator, "Col-1");
        Collegue collegue2 = new ConcretaCollegue(concreteMediator, "Col-2");
        Collegue collegue3 = new ConcretaCollegue(concreteMediator, "Col-3");
        concreteMediator.addCollegues(collegue1);
        concreteMediator.addCollegues(collegue2);
        concreteMediator.addCollegues(collegue3);
        collegue1.changeStatus();
    }
}
interface Mediator{
    void requestAll(Collegue collegue);
}
class ConcreteMediator implements Mediator{
    List<Collegue> collegues = new ArrayList<>();
    void addCollegues(Collegue collegue){
        this.collegues.add(collegue);
    }

    @Override
    public void requestAll(Collegue collegue) {
        collegue.setTrue();
        for(Collegue colleg : collegues){
            if(colleg != collegue){
                colleg.setFalse();
            }
        }
    }
}
interface Collegue{
    void setFalse();
    void setTrue();
    void changeStatus();
}
class ConcretaCollegue implements Collegue{
    String name;
    boolean status;
    Mediator mediator;

    public ConcretaCollegue(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void setFalse() {
        status = false;
        System.out.println(name + " - my status is false");
    }

    @Override
    public void setTrue() {
        status = true;
        System.out.println(name + " - my status is true");
    }

    @Override
    public void changeStatus() {
        mediator.requestAll(this);
    }
}
