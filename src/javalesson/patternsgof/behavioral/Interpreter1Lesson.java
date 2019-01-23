package javalesson.patternsgof.behavioral;

public class Interpreter1Lesson {
    public static void main(String[] args) {
        Expression isJava = getJavaExpression();
        Expression isJavaEEDeveloper = getJavaEEExpression();

        System.out.println("Does developer knows Java Core: " + isJava.inerpret("Java Core"));
        System.out.println("Does developer knows Java EE: " + isJavaEEDeveloper.inerpret("Java Spring"));
    }
    public static Expression getJavaExpression(){
        Expression java = new TerminalExpression("Java");
        Expression javaCore = new TerminalExpression("Java Core");
        return new OrExpression(java, javaCore);
    }
    public static Expression getJavaEEExpression(){
        Expression java = new TerminalExpression("Java");
        Expression spring = new TerminalExpression("Spring");
        return new AndExpression(java, spring);
    }
}
interface Expression{
    boolean inerpret(String context);
}
class AndExpression implements Expression{
    private Expression expression1;
    private Expression expression2;
    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
    @Override
    public boolean inerpret(String context) {
        return expression1.inerpret(context) && expression2.inerpret(context);
    }
}
class OrExpression implements Expression{
    private Expression expression1;
    private Expression expression2;
    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
    @Override
    public boolean inerpret(String context) {
        return expression1.inerpret(context) || expression2.inerpret(context);
    }
}
class TerminalExpression implements Expression{
    private String data;
    public TerminalExpression(String data) {
        this.data = data;
    }
    @Override
    public boolean inerpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}
