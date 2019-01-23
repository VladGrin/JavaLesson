package javalesson.patterns;

public class BuilderApp {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .setName("Vova")
                .setSurname("Mok")
                .setAge(20)
                .build();
        System.out.println(person);
        person = new PersonBuilder()
                .setName("Lens")
                .setSurname("Bob")
                .setAge(30)
                .build();
        System.out.println(person);
    }
}
class Person{
    private String name;
    private String surname;
    private int age;

    Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
class PersonBuilder{
    String name;
    String surname;
    int age;
    PersonBuilder setName(String name){
        this.name = name;
        return this;
    }
    PersonBuilder setSurname(String surname){
        this.surname = surname;
        return this;
    }
    PersonBuilder setAge(int age){
        this.age = age;
        return this;
    }
    Person build(){
        return new Person(this);
    }
}