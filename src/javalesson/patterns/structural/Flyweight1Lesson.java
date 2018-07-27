package javalesson.patterns.structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flyweight1Lesson {
    public static void main(String[] args) {
        DeveloperFactoryFlyWeight developerFactory = new DeveloperFactoryFlyWeight();
        List<DeveloperFly> developers = new ArrayList<>();
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));

        for(DeveloperFly developerFly : developers){
            developerFly.writeCode();
        }
    }
}

interface DeveloperFly {
    void writeCode();
}

class JavaDeveloperFly implements DeveloperFly {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes java code...");
    }
}

class CppDeveloperFly implements DeveloperFly {
    @Override
    public void writeCode() {
        System.out.println("C++ developer writes c++ code...");
    }
}

class DeveloperFactoryFlyWeight {
    private static final Map<String, DeveloperFly> developers = new HashMap<>();

    public DeveloperFly getDeveloperBySpecialty(String specialty) {
        DeveloperFly developerFly = developers.get(specialty);
        if (developerFly == null) {
            switch (specialty) {
                case "java": {
                    System.out.println("Hiring Java Developer...");
                    developerFly = new JavaDeveloperFly();
                    break;
                }
                case "c++" : {
                    System.out.println("Hiring C++ developer...");
                    developerFly = new CppDeveloperFly();
                    break;
                }
            }
            developers.put(specialty, developerFly);
        }
        return developerFly;
    }
}
