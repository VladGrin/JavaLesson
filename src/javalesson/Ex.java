package javalesson;

import java.util.Optional;

public class Ex {
    public static void main(String[] args) {
        CarFactory carFactory = shooceFactory("audi");
        Car car = carFactory.create();

        car.transportPeople();
        String notNumber = null;
//        Optional<String> optionalS = Optional.of(notNumber);
//        optionalS.ifPresent(System.out::println);
        Optional<String> optionalS = Optional.empty();
        String value = optionalS.orElse("bar");
        System.out.println(value);
    }

    static CarFactory shooceFactory(String string) {
        switch (string) {
            case "bmw":
                return new BMWFactory();
            case "mers":
                return new MersFactory();
            case "audi":
                return new AudiFactory();
            default:
                throw new RuntimeException(string + "not found.");
        }
    }
}

interface Car {
    void transportPeople();
}

class BMW implements Car {
    @Override
    public void transportPeople() {
        System.out.println("BMW transport people ...");
    }
}

class Mers implements Car {
    @Override
    public void transportPeople() {
        System.out.println("Mers transport people ...");
    }
}

class Audi implements Car{
    @Override
    public void transportPeople() {
        System.out.println("Audi transport people ...");
    }
}

interface CarFactory {
    Car create();
}

class BMWFactory implements CarFactory {
    @Override
    public Car create() {
        return new BMW();
    }
}

class MersFactory implements CarFactory {
    @Override
    public Car create() {
        return new Mers();
    }
}

class AudiFactory implements CarFactory {
    @Override
    public Car create() {
        return new Audi();
    }
}