package javalesson.patterns.creational;

public class Prototype1Lesson {
    public static void main(String[] args) {
        Project master = new Project(1, "SuperProject", "SourceCode sourceCode = new SourceCode()");
        System.out.println(master);
        Project projectClone = (Project) master.copy();
        System.out.println(projectClone);
        ProjectFactory projectFactory = new ProjectFactory(master);
        Project projectClone1 = projectFactory.cloneProject();
        System.out.println(projectClone1);
    }
}
interface Copyable{
    Object copy();
}
class Project implements Copyable{
    private int id;
    private String projectName;
    private String sourceCode;
    public Project(int id, String projectName, String sourceCode) {
        this.id = id;
        this.projectName = projectName;
        this.sourceCode = sourceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Override
    public Object copy() {
        Project copy = new Project(id, projectName, sourceCode);
        return copy;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                '}';
    }
}
class ProjectFactory{
    Project project;

    public ProjectFactory(Project project) {
        this.project = project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    Project cloneProject(){
        return (Project)project.copy();
    }
}