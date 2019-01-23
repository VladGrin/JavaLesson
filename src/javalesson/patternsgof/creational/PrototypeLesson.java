package javalesson.patternsgof.creational;

public class PrototypeLesson {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cash cash = new Cash();
        cash.setStudent(new Student());

        Student student = cash.getStudent();
        student.method();
    }
}

class Student implements Cloneable{

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }

    void method(){
        System.out.println("i am student");
    }
}
class Cash{
    private Student student;

    public Student getStudent() throws CloneNotSupportedException {
        System.out.println("get clone student");
        return student.clone();
    }

    public void setStudent(Student student) {
        System.out.println("set student");
        this.student = student;
    }
}
