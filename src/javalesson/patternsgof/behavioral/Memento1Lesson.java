package javalesson.patternsgof.behavioral;

import java.util.Date;

public class Memento1Lesson {
    public static void main(String[] args) throws InterruptedException {
        Project project = new Project();
        GitHubRepo gitHub = new GitHubRepo();

        System.out.println("Create new project. Version 1.0 ");
        project.setVersionDate("Version 1.0");
        System.out.println(project);

        System.out.println("Saving curent version to GitHub...");
        gitHub.setSave(project.save());
        Thread.sleep(5000);
        System.out.println("Updating project to version 1.1");
        System.out.println("Write poor code...");

        project.setVersionDate("Version 1.1");
        System.out.println(project);
        Thread.sleep(3000);
        System.out.println("Something went wrong...");
        System.out.println("Rolling back to version 1.0");
        project.load(gitHub.getSave());

        System.out.println("Project after rollback");
        System.out.println(project);
    }
}
class Project{
    private String version;
    private Date date;

    void setVersionDate(String version) {
        this.version = version;
        this.date = new Date();
    }
    public Save save(){
        return new Save(version);
    }
    public void load(Save save){
        version = save.getVersion();
        date = save.getData();
    }
    @Override
    public String toString() {
        return "Project{" +
                "version='" + version + '\'' +
                ", date=" + date +
                '}';
    }
}
class Save{
    private final String version;
    private final Date data;

    public Save(String version) {
        this.version = version;
        this.data = new Date();
    }

    public String getVersion() {
        return version;
    }

    public Date getData() {
        return data;
    }

}
class GitHubRepo{
    private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}