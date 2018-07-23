package javalesson.patterns.structural;

public class Decorator1Lesson {
    public static void main(String[] args) {
        DeveloperA javaDeveloperA = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloperA()));
        System.out.println(javaDeveloperA.makeJob());
    }
}
interface DeveloperA{
    public String makeJob();
}
class JavaDeveloperA implements DeveloperA{
    @Override
    public String makeJob() {
        return "Write java code. ";
    }
}
class DeveloperDecorator implements DeveloperA{
    DeveloperA developerA;

    public DeveloperDecorator(DeveloperA developerA) {
        this.developerA = developerA;
    }

    @Override
    public String makeJob() {
        return developerA.makeJob();
    }
}
class SeniorJavaDeveloper extends DeveloperDecorator{

    public SeniorJavaDeveloper(DeveloperA developerA) {
        super(developerA);
    }

    public String makeCodereview(){
        return "Make code review. ";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodereview();
    }
}
class JavaTeamLead extends DeveloperDecorator{

    public JavaTeamLead(DeveloperA developerA) {
        super(developerA);
    }
    public String sendWeekReport(){
        return "Send week repoert to customer. ";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + sendWeekReport();
    }
}