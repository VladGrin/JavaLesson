package javalesson.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StreamTaskPeople {
    public static void main(String[] args) {
        List<People> peopleList = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN));
        List<People> newPeopleList = peopleList.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 27 && x.getSex() == Sex.MAN)
                .collect(Collectors.toList());
        newPeopleList.stream().forEach(System.out::println);

        Double result = peopleList.stream()
                .filter(x -> x.getSex() == Sex.MAN)
                .mapToInt(People::getAge)
                .average()
                .getAsDouble();
        System.out.println(result);

        long count = peopleList.stream()
                .filter(x -> x.getAge() >= 18)
                .filter(x ->
                        (x.getAge() <= 55 && x.getSex() == Sex.WOMEN) ||
                                (x.getAge() <= 60 && x.getSex() == Sex.MAN))
                .count();
        System.out.println(count);

    }
}

class People {
    private String name;
    private int age;
    private Sex sex;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

enum Sex {
    MAN, WOMEN
}
