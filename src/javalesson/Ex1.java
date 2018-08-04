package javalesson;

public class Ex1 {
    public static void main(String[] args) {
        Notifier simple = new SimpleReportNotifier(1);
        Notifier email = new EmailNotifier(2);
        Notifier sms = new SmsNotifier(3);
        simple.setNextNotifier(email);
        email.setNextNotifier(sms);
        simple.notifyMeneger("Ok", 1);
        System.out.println();
        simple.notifyMeneger("Warning", 2);
        System.out.println();
        simple.notifyMeneger("SOS", 3);
    }
}

abstract class Notifier {
    private int priority;
    private Notifier nextNotifier;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifyMeneger(String message, int level) {
        if (level >= priority) {
            write(message);
        }
        if (nextNotifier != null) {
            nextNotifier.notifyMeneger(message, level);
        }
    }

    public abstract void write(String message);
}

class SimpleReportNotifier extends Notifier {

    public SimpleReportNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Notifing using simple report " + message);
    }
}

class EmailNotifier extends Notifier {

    public EmailNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Notifing Email " + message);
    }
}

class SmsNotifier extends Notifier {

    public SmsNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Notifing SMS " + message);
    }
}