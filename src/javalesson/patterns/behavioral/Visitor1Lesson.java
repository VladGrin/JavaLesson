package javalesson.patterns.behavioral;

public class Visitor1Lesson {
    public static void main(String[] args) {
        MyProject project = new MyProject();

        DeveloperV junior = new JuniorDeveloper();
        DeveloperV senior = new SeniorDeveloper();

        System.out.println("Junior in Action...");
        project.beWritten(junior);
        System.out.println("Senior in Action...");
        project.beWritten(senior);
    }
}
interface ProjectElement{
    void beWritten(DeveloperV developer);
}
class ProjectClass implements ProjectElement{

    @Override
    public void beWritten(DeveloperV developer) {
        developer.create(this);
    }
}
class DataBase implements ProjectElement{

    @Override
    public void beWritten(DeveloperV developer) {
        developer.create(this);
    }
}
class Test implements ProjectElement{

    @Override
    public void beWritten(DeveloperV developer) {
        developer.create(this);
    }
}
interface DeveloperV{
    void create(ProjectClass projectClass);
    void create(DataBase dataBase);
    void create(Test test);
}
class MyProject implements ProjectElement{
    ProjectElement[] projectElements;

    public MyProject() {
        this.projectElements = new ProjectElement[]{
                new ProjectClass(),
                new DataBase(),
                new Test()
        };
    }

    @Override
    public void beWritten(DeveloperV developer) {
        for(ProjectElement element : projectElements){
            element.beWritten(developer);
        }
    }
}
class JuniorDeveloper implements DeveloperV{

    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Writing poor class...");
    }

    @Override
    public void create(DataBase dataBase) {
        System.out.println("Drop Database...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Create not reliable test...");
    }
}
class SeniorDeveloper implements DeveloperV{

    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Rewriting code after junior...");
    }

    @Override
    public void create(DataBase dataBase) {
        System.out.println("Fixing Database...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Writing reliable test...");
    }
}