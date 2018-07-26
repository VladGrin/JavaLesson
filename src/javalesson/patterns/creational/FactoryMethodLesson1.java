package javalesson.patterns.creational;

public class FactoryMethodLesson1 {
    public static void main(String[] args) {
//        DeveloperFactory developerFactory = createDeveloperBySpeciality("php");
//        Developer developer = developerFactory.createDeveloper();
//        developer.writeCode();

        createDeveloperBySpeciality("php").createDeveloper().writeCode();
    }
    static DeveloperFactory createDeveloperBySpeciality(String speciality){
        switch (speciality){
            case "java" : return new JavaDeveloperFactory();
            case "cpp" : return new CppDeveloperFactory();
            case "php" : return new PhpDeveloperFactory();
            default: throw new RuntimeException(speciality + " unknown speciality.");
        }
    }
}
interface Developer{
    void writeCode();
}
class JavaDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("Java developer write code...");
    }
}
class CppDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("Cpp developer write code...");
    }
}
class PhpDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("Php developer write code...");
    }
}
interface DeveloperFactory{
    Developer createDeveloper();
}
class JavaDeveloperFactory implements DeveloperFactory{
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}
class CppDeveloperFactory implements DeveloperFactory{
    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}
class PhpDeveloperFactory implements DeveloperFactory{
    @Override
    public Developer createDeveloper() {
        return new PhpDeveloper();
    }
}