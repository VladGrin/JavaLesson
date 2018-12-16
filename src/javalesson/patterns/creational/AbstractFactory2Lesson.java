package javalesson.patterns.creational;

public class AbstractFactory2Lesson {
    public static void main(String[] args) {
        IToyFactory toyFactory = new WoodenToysFactory();
        Bear bear = toyFactory.GetBear();
        Cat cat = toyFactory.GetCat();
        System.out.println("I've got " + bear.getName() + " and " + cat.getName());
        toyFactory = new TeddyToysFactory();
        bear = toyFactory.GetBear();
        cat = toyFactory.GetCat();
        System.out.println("I've got " + bear.getName() + " and " + cat.getName());
    }
}

interface IToyFactory {
    Bear GetBear();
    Cat GetCat();
}

class TeddyToysFactory implements IToyFactory {
    @Override
    public Bear GetBear() {
        return new TeddyBear();
    }

    @Override
    public Cat GetCat() {
        return new TeddyCat();
    }
}

class WoodenToysFactory implements IToyFactory {
    @Override
    public Bear GetBear() {
        return new WoodenBear();
    }

    @Override
    public Cat GetCat() {
        return new WoodenCat();
    }
}

abstract class AnimalToy {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

abstract class Cat extends AnimalToy {
}

abstract class Bear extends AnimalToy {
}

class WoodenCat extends Cat {
    @Override
    public String getName() {
        return  "Wooden Cat";
    }
}

class TeddyCat extends Cat {
    @Override
    public String getName() {
        return "Teddy Cat";
    }
}

class WoodenBear extends Bear {
    @Override
    public String getName() {
        return "Wooden Bear";
    }
}

class TeddyBear extends Bear {
    @Override
    public String getName() {
        return "Teddy Bear";
    }
}
