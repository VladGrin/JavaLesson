package javalesson.patternsgof.structural;

public class Proxy1Lesson {
    public static void main(String[] args) {
//        Project project = new RealProject("https://www.github.com/dv");
        Project project = new ProxyProject("https://www.github.com/dv");
        project.run();
    }
}
interface Project{
    void run();
}
class RealProject implements Project{
    String url;
    public RealProject(String url) {
        this.url = url;
        load();
    }
    private void load(){
        System.out.println("Loading project from " + url + " ...");
    }
    @Override
    public void run() {
        System.out.println("Running project " + url + " ...");
    }
}
class ProxyProject implements Project{
    private String url;
    private RealProject realProject;
    public ProxyProject(String url) {
        this.url = url;
    }
    @Override
    public void run() {
        if (realProject == null){
            realProject = new RealProject(url);
        }
        realProject.run();
    }
}
