package javalesson.patterns;

public class DecoratorApp {
    public static void main(String[] args) {
        PrintInterface printInterface = new LeftBraketDecorator(
                new RightBraketDecorator(new QuotesDecorator(new Printer("Hello"))));
        printInterface.printpString();
    }
}

interface PrintInterface {
    void printpString();
}

abstract class Decorator implements PrintInterface {
    PrintInterface component;

    Decorator(PrintInterface component) {
        this.component = component;
    }

    @Override
    public abstract void printpString();
}

class Printer implements PrintInterface {
    private String value;

    Printer(String value) {
        this.value = value;
    }

    @Override
    public void printpString() {
        System.out.print(value);
    }
}

class QuotesDecorator extends Decorator {
    QuotesDecorator(PrintInterface component) {
        super(component);
    }

    @Override
    public void printpString() {
        System.out.print("/");
        component.printpString();
        System.out.print("/");
    }
}

class LeftBraketDecorator extends Decorator {

    LeftBraketDecorator(PrintInterface component) {
        super(component);
    }

    @Override
    public void printpString() {
        System.out.print("[");
        component.printpString();
    }
}

class RightBraketDecorator extends Decorator {

    RightBraketDecorator(PrintInterface component) {
        super(component);
    }

    @Override
    public void printpString() {
        component.printpString();
        System.out.print("]");
    }
}