package javalesson.patterns.creational;

public class AbstractFactoryLesson {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new AbstractFactory();
        NewFactory newCarFactory = abstractFactory.createFactory("Car");
        NewFactory newTankFactory = abstractFactory.createFactory("Tank");
        NewTank T51 = newTankFactory.createTank("T51");
        NewTank TR52 = newTankFactory.createTank("TR52");
        T51.method();
        TR52.method();
        NewCar BMW = newCarFactory.createCar("BMW");
        NewCar Mers = newCarFactory.createCar("Mers");
        BMW.method();
        Mers.method();
    }
}

interface NewCar {
    void method();
}

class BMW implements NewCar {
    @Override
    public void method() {
        System.out.println("drive BMW");
    }
}

class Mers implements NewCar {
    @Override
    public void method() {
        System.out.println("drive Mers");
    }
}

interface NewTank {
    void method();
}

class T51 implements NewTank {
    @Override
    public void method() {
        System.out.println("drive T51");
    }
}

class TR52 implements NewTank {
    @Override
    public void method() {
        System.out.println("drive TR52");
    }
}

class NewCarFactory implements NewFactory {
    public NewCar createCar(String s) {
        switch (s) {
            case "BMW":
                return new BMW();
            case "Mers":
                return new Mers();
            default:
                return null;
        }
    }

    @Override
    public NewTank createTank(String s) {
        return null;
    }
}

class NewTankFactory implements NewFactory {
    @Override
    public NewCar createCar(String s) {
        return null;
    }

    public NewTank createTank(String s) {
        switch (s) {
            case "T51":
                return new T51();
            case "TR52":
                return new TR52();
            default:
                return null;
        }
    }
}

interface NewFactory {
    NewCar createCar(String s);
    NewTank createTank(String s);
}

class AbstractFactory {
    NewFactory createFactory(String str) {
        switch (str) {
            case "Car":
                return new NewCarFactory();
            case "Tank":
                return new NewTankFactory();
            default:
                return null;
        }
    }
}