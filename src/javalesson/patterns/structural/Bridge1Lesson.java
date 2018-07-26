package javalesson.patterns.structural;

public class Bridge1Lesson {
    public static void main(String[] args) {
        Program[] programs = {
                new BankSystem(new JavaDeveloper()),
                new StockExchange(new CppDeveloper())
        };

        for (Program program : programs) {
            program.developProgram();
        }
    }
}

abstract class Program {
    Developer developer;

    public Program(Developer developer) {
        this.developer = developer;
    }

    public abstract void developProgram();
}

class BankSystem extends Program {
    public BankSystem(Developer developer) {
        super(developer);
    }
    @Override
    public void developProgram() {
        System.out.println("Bank System development in progress...");
        developer.writeCode();
    }
}
class StockExchange extends Program {
    public StockExchange(Developer developer) {
        super(developer);
    }
    @Override
    public void developProgram() {
        System.out.println("Stock Exchange development in progress...");
        developer.writeCode();
    }
}

interface Developer {
    void writeCode();
}
class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("java developer writes java code...");
    }
}
class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("C++ developer writes code...");
    }
}