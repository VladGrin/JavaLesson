package javalesson.patterns.behavioral;

public class Command2Lesson {
    public static void main(String[] args) {
        Comp comp = new Comp();
        UserComp user = new UserComp(
                new StartCommand(comp),
                new StopCommand(comp),
                new ResetCommand(comp)
        );
        user.startComp();
        user.stopComp();
        user.resetComp();

    }
}
interface CommandComp{
    void execute();
}
//Resiver
class Comp{
    void start(){
        System.out.println("Start comp...");
    }
    void stop(){
        System.out.println("Stop comp...");
    }
    void reset(){
        System.out.println("Reset comp...");
    }
}
class StartCommand implements CommandComp{
    Comp comp;
    public StartCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.start();
    }
}
class StopCommand implements CommandComp{
    Comp comp;
    public StopCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.stop();
    }
}
class ResetCommand implements CommandComp{
    Comp comp;
    public ResetCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.reset();
    }
}
//Invoker
class UserComp{
    CommandComp start;
    CommandComp stop;
    CommandComp reset;
    public UserComp(CommandComp start, CommandComp stop, CommandComp reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startComp(){
        start.execute();
    }
    void stopComp(){
        stop.execute();
    }
    void resetComp(){
        reset.execute();
    }
}