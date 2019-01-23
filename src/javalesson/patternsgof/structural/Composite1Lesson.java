package javalesson.patternsgof.structural;

import java.util.ArrayList;
import java.util.List;

public class Composite1Lesson {
    public static void main(String[] args) {
        Team team = new Team();

        Developers firstJavaDeveloper = new JavaDevelopers();
        Developers secondJavaDeveloper = new JavaDevelopers();
        Developers cppDeveloper = new CppDevelopers();

        team.addDeveloper(firstJavaDeveloper);
        team.addDeveloper(secondJavaDeveloper);
        team.addDeveloper(cppDeveloper);

        team.createProject();
    }
}
class Team{
    private List<Developers> developers = new ArrayList<>();
    public void addDeveloper(Developers developer){
        developers.add(developer);
    }
    public void removeDeveloper(Developers developer){
        developers.remove(developer);
    }
    public void createProject(){
        System.out.println("Team create project...\n");
        for(Developers developer : developers){
            developer.writeCode();
        }
    }
}
interface Developers{
    void writeCode();
}
class JavaDevelopers implements Developers{
    @Override
    public void writeCode() {
        System.out.println("Java developer writes jaca code...");
    }
}
class CppDevelopers implements Developers{
    @Override
    public void writeCode() {
        System.out.println("Cpp developer writes cpp code...");
    }
}