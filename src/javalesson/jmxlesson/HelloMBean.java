package javalesson.jmxlesson;

public interface HelloMBean {
    void sayHello();
    int addIntegers(int a, int b);
    Person getPerson();
    String getName();
    void setName();
}
