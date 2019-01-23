package javalesson.patternsgof.creational;

public class AbstractFactory1Lesson {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        Developer1 developer1 = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManajer();

        System.out.println("Create Project ...");
        developer1.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
interface Developer1{
    void writeCode();
}
interface Tester{
    void testCode();
}
interface ProjectManager{
    void manageProject();
}
interface ProjectTeamFactory{
    Developer1 getDeveloper();
    Tester getTester();
    ProjectManager getProjectManajer();
}
class JavaDeveloper1 implements Developer1{
    @Override
    public void writeCode() {
        System.out.println("JAVA Developer writes code");
    }
}
class QATester implements Tester{
    @Override
    public void testCode() {
        System.out.println("QA tester tests banking code.");
    }
}
class BankingPM implements ProjectManager{
    @Override
    public void manageProject() {
        System.out.println("PM manage banking code.");
    }
}
class BankingTeamFactory  implements ProjectTeamFactory{
    @Override
    public Developer1 getDeveloper() {
        return new JavaDeveloper1();
    }
    @Override
    public Tester getTester() {
        return new QATester();
    }
    @Override
    public ProjectManager getProjectManajer() {
        return new BankingPM();
    }
}
class PHPDeveloper implements Developer1{
    @Override
    public void writeCode() {
        System.out.println("PHP Developer writes code.");
    }
}
class ManualTester implements Tester{
    @Override
    public void testCode() {
        System.out.println("Manual tester tests code.");
    }
}
class WebSitePM implements ProjectManager{
    @Override
    public void manageProject() {
        System.out.println("Web site PM sites project.");
    }
}
class WEBSiteTeamFactory implements ProjectTeamFactory{
    @Override
    public Developer1 getDeveloper() {
        return new PHPDeveloper();
    }
    @Override
    public Tester getTester() {
        return new ManualTester();
    }
    @Override
    public ProjectManager getProjectManajer() {
        return new WebSitePM();
    }
}
