package javalesson.patternsgof.behavioral;

public class ChainOfResponsibility2Lesson {
    public static void main(String[] args) {
        SMSLogger log1 = new SMSLogger(1);
        FileLogger log2 = new FileLogger(2);
        EmailLogger log3 = new EmailLogger(3);
        log1.setNext(log2);
        log2.setNext(log3);

        log1.writeMessage("SOS", 1);
        System.out.println();
        log1.writeMessage("Warning", 2);
        System.out.println();
        log1.writeMessage("All right", 3);
    }
}
class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO  = 3;
}
abstract class Logger{
    public int priority;
    public Logger next;
    public Logger(int priority) {
        this.priority = priority;
    }
    public void setNext(Logger next) {
        this.next = next;
    }
    public void writeMessage(String message, int level) {
        if (level <= priority){
            write(message);
        }
        if(next != null){
            next.writeMessage(message, level);
        }
    }
    abstract void write(String message);
}
class SMSLogger extends Logger{
    public SMSLogger(int priority) {
        super(priority);
    }
    @Override
    void write(String message) {
        System.out.println("SMS : " + message);
    }

}
class FileLogger extends Logger{
    public FileLogger(int priority) {
        super(priority);
    }
    @Override
    void write(String message) {
        System.out.println("File : " + message);
    }
}
class EmailLogger extends Logger{
    public EmailLogger(int priority) {
        super(priority);
    }
    @Override
    void write(String message) {
        System.out.println("Email : " + message);
    }
}