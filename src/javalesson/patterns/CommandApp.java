package javalesson.patterns;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(new StartCommand(comp), new StopCommand(comp), new ResetCommand(comp));
        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}
interface Command{
    void execute();
}
class Comp{
    void start(){
        System.out.println("START");
    }
    void stop(){
        System.out.println("STOP");
    }
    void reset(){
        System.out.println("RESET");
    }
}
class StartCommand implements Command{
    private Comp comp;
    public StartCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.start();
    }
}
class StopCommand implements Command{
    private Comp comp;
    public StopCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.stop();
    }
}
class ResetCommand implements Command{
    private Comp comp;
    public ResetCommand(Comp comp) {
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.reset();
    }
}
class User{
    private Command start;
    private Command stop;
    private Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }
}