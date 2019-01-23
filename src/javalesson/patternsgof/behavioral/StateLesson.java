package javalesson.patternsgof.behavioral;

public class StateLesson {
    public static void main(String[] args) {
        Context context = new Context(new LowerCase(), "Max");
        context.doAction();
        context.setState(new UpperCase());
        context.doAction();
    }
}
interface State{
    void doAction(Context context);
}
class LowerCase implements State{

    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toLowerCase());
    }
}
class UpperCase implements State{

    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toUpperCase());
    }
}
class Context{
    State state;
    String name;

    public Context(State state, String name) {
        this.state = state;
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }
    public void doAction(){
        state.doAction(this);
    }
}