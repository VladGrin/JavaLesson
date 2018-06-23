package javalesson.solid;

public class SingleResponsibility {
}

//class Employee{
//    int getSalary(){return 10;}
//    void cook(){}
//    void clearFloor(){}
//    void deliverFood(){}
//}
interface Employee {
    int getSalary();
}

class Cook implements Employee {
    void cook() {
    }

    @Override
    public int getSalary() {
        return 0;
    }
}

class Janitor implements Employee {
    @Override
    public int getSalary() {
        return 0;
    }

    void clearFloor() {
    }
}

class EmployeeFacade {
    Cook cook = new Cook();
    Janitor janitor = new Janitor();
    void cook(){
        cook.cook();
    }
    void clearFloor(){
        janitor.clearFloor();
    }
}