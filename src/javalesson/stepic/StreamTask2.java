package javalesson.stepic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTask2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alex", Speciality.Physics, 1),
                new Student("Rika", Speciality.Biology, 4),
                new Student("Julia", Speciality.Biology, 2),
                new Student("Steve", Speciality.History, 4),
                new Student("Mike", Speciality.Finance, 1),
                new Student("Hinata", Speciality.Biology, 2),
                new Student("Richard", Speciality.History, 1),
                new Student("Kate", Speciality.Psychology, 2),
                new Student("Sergey", Speciality.ComputerScience, 4),
                new Student("Maximilian", Speciality.ComputerScience, 3),
                new Student("Tim", Speciality.ComputerScience, 5),
                new Student("Ann", Speciality.Psychology, 1)
        );
        students.stream()
                .collect(Collectors.groupingBy(Student::getYear))
                .entrySet().forEach(System.out::println);
    }

}
enum Speciality {
    Biology, ComputerScience, Economics, Finance,
    History, Philosophy, Physics, Psychology
}
class Student{
    private String name;
    private Speciality speciality;
    private int year;

    public Student(String name, Speciality speciality, int year) {
        this.name = name;
        this.speciality = speciality;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year &&
                Objects.equals(name, student.name) &&
                speciality == student.speciality;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, speciality, year);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", speciality=" + speciality +
                ", year=" + year +
                '}';
    }
}
