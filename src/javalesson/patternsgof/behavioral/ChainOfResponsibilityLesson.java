package javalesson.patternsgof.behavioral;

public class ChainOfResponsibilityLesson {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        MessagePrinter fileMessagePrinter = new FileMessagePrinter();
        MessagePrinter BDMessagePrinter = new DatabaseMessagePrinter();
        messagePrinter.setNextMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNextMessagePrinter(BDMessagePrinter);
        messagePrinter.print("hello");
    }
}
abstract class MessagePrinter{
    MessagePrinter nextMessagePrinter;
    void setNextMessagePrinter(MessagePrinter messagePrinter){
        nextMessagePrinter = messagePrinter;
    }
    void print(String message){
        printMessage(message);
        if(nextMessagePrinter != null){
            nextMessagePrinter.print(message);
        }
    }
    abstract void printMessage(String message);
}
class ConsoleMessagePrinter extends MessagePrinter{

    @Override
    void printMessage(String message) {
        System.out.println("Print to console " + message);
    }
}
class FileMessagePrinter extends MessagePrinter{

    @Override
    void printMessage(String message) {
        System.out.println("Print to file " + message);
    }
}
class DatabaseMessagePrinter extends MessagePrinter{

    @Override
    void printMessage(String message) {
        System.out.println("Print to database " + message);
    }
}