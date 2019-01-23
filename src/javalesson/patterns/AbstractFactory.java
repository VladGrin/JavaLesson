package javalesson.patterns;

public class AbstractFactory {
    public static void main(String[] args) {
        ShapeFactory factory = new GreenShape();
        factory.getTrapezoid().getName();
        factory.getParallelogram().getName();
        factory = new RedShape();
        factory.getTrapezoid().getName();
        factory.getParallelogram().getName();

    }
}

interface ShapeFactory{
    Trapezoid getTrapezoid();
    Parallelogram getParallelogram();
}
class RedShape implements ShapeFactory{

    @Override
    public Trapezoid getTrapezoid() {
        return new RedTrapezoid();
    }

    @Override
    public Parallelogram getParallelogram() {
        return new RedParallelogram();
    }
}
class GreenShape implements ShapeFactory{

    @Override
    public Trapezoid getTrapezoid() {
        return new GreenTrapezoid();
    }

    @Override
    public Parallelogram getParallelogram() {
        return new GreenParallelogram();
    }
}

abstract class Trapezoid{
    abstract void getName();
}
abstract class Parallelogram{
    abstract void getName();
}
class RedTrapezoid extends Trapezoid{

    @Override
    void getName() {
        System.out.println("Draw red Trapezoid");
    }
}
class RedParallelogram extends Parallelogram{

    @Override
    void getName() {
        System.out.println("Draw red Parallelogram");
    }
}
class GreenTrapezoid extends Trapezoid{

    @Override
    void getName() {
        System.out.println("Draw green Trapezoid");
    }
}
class GreenParallelogram extends Parallelogram{

    @Override
    void getName() {
        System.out.println("Draw green Parallelogram");
    }
}












interface ICarFactory{
    Mersedes getMers();
    Volvo getVolvo();
}
class CarFactory implements ICarFactory{

    @Override
    public Mersedes getMers() {
        return new CarMers();
    }

    @Override
    public Volvo getVolvo() {
        return new CarVolvo();
    }
}
class TrackFactory implements ICarFactory{

    @Override
    public Mersedes getMers() {
        return new TrackMers();
    }

    @Override
    public Volvo getVolvo() {
        return new TrackVolvo();
    }
}

abstract class Mersedes {
    abstract void getName();
}
abstract class Volvo {
    abstract void getName();
}
class CarMers extends Mersedes{
    @Override
    public void getName(){
        System.out.println("Car Mers");
    }
}
class CarVolvo extends Volvo{
    @Override
    public void getName(){
        System.out.println("Car Volvo");
    }
}
class TrackMers extends Mersedes{
    @Override
    public void getName(){
        System.out.println("Track Mers");
    }
}
class TrackVolvo extends Volvo{
    @Override
    public void getName(){
        System.out.println("Track Volvo");
    }
}