package javalesson.patterns;

import java.util.ArrayList;
import java.util.List;

public class FilterLesson {
    public static void main(String[] args) {
        Car car1 = new Car(150,"green",4);
        Car car2 = new Car(200,"red",2);
        Car car3 = new Car(250,"black",4);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars = new SpeedFilter().filter(cars);
        for(Car car : cars){
            System.out.println(car);
        }
    }
}
interface CarFilter{
    List<Car> filter(List<Car> cars);
}
class SpeedFilter implements CarFilter{

    @Override
    public List<Car> filter(List<Car> cars) {
        List<Car> list = new ArrayList<>();
        for(Car car : cars){
            if (car.getMaxSpeed() > 180){
                list.add(car);
            }
        }
        return list;
    }
}
class Car {
    private int maxSpeed;
    private String color;
    private int doors;
    public Car(int maxSpeed, String color, int doors) {
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.doors = doors;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                ", doors=" + doors +
                '}';
    }
}

