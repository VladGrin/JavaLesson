package javalesson.solid;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Toyota toyota = new Toyota();
        Celica celica = new Celica();
        workInTaxi(toyota);
    }

    static void workInTaxi(Car car) {
        car.workInTaxi();
    }
}

// main -> toyota
// main -> Car <- toyota

interface Car{
    void workInTaxi();
}

class Toyota implements Car{
    void getPasangers() {
        System.out.println("get passangers");
    }
    @Override
    public void workInTaxi() {
        getPasangers();
    }
}

class Celica extends Toyota {
    @Override
    public void workInTaxi() {
        getPasanger();
    }
    void getPasanger() {
        System.out.println("get one passanger");
    }
}