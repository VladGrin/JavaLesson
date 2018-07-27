package javalesson.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class CommandLesson {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        receiver.addCommand(new MouseClick());
        receiver.addCommand(new MouseClick());
        receiver.addCommand(new MousePush());
        receiver.addCommand(new MousePush());
        receiver.runCommand();
    }
}
interface Command1{
    void execute();
}
class MouseClick implements Command1{

    @Override
    public void execute() {
        System.out.println("Click command");
    }
}
class MousePush implements Command1{

    @Override
    public void execute() {
        System.out.println("Click command Push");
    }
}
class Receiver{
    private List<Command1> command1s = new ArrayList<>();
    void addCommand(Command1 command1){
        command1s.add(command1);
    }
    void runCommand(){
        for(Command1 command1 : command1s){
            command1.execute();
        }
    }
}