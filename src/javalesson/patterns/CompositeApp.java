package javalesson.patterns;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();

        Shape square3 = new Square();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape circle3 = new Circle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponents(square1);
        composite1.addComponents(square2);
        composite1.addComponents(triangle1);

        composite2.addComponents(square3);
        composite2.addComponents(circle1);
        composite2.addComponents(circle2);
        composite2.addComponents(circle3);

        composite.addComponents(composite1);
        composite.addComponents(composite2);

        composite.draw();
    }
}
interface Shape{
    void draw();
}
class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw square");
    }
}
class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw triangle");
    }
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw circle");
    }
}
class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();
    public void addComponents(Shape component){
        components.add(component);
    }
    public void removeComponents(Shape component){
        components.remove(component);
    }

    @Override
    public void draw() {
        for(Shape shape : components){
            shape.draw();
        }
    }
}