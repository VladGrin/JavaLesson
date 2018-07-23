package javalesson.patterns.structural;

public class Bridge1Lesson {
    public static void main(String[] args) {
        Shape[] shape = {
                new Rectangle(new Blue()),
                new Square(new Red()),
                new Circle(new Green())
        };
        for (Shape shape1: shape){
            shape1.drawShape();
        }
    }
}
abstract class Shape{
    Color color;
    public Shape(Color color) {
        this.color = color;
    }
    abstract void drawShape();
}
class Rectangle extends Shape{
    public Rectangle(Color color) {
        super(color);
    }
    @Override
    void drawShape() {
        System.out.println("draw RECTANGLE");
        color.fillColor();
    }
}
class Square extends Shape{
    public Square(Color color) {
        super(color);
    }
    @Override
    void drawShape() {
        System.out.println("draw SQUARE");
        color.fillColor();
    }
}
class Circle extends Shape{
    public Circle(Color color) {
        super(color);
    }
    @Override
    void drawShape() {
        System.out.println("draw CIRCLE");
        color.fillColor();
    }
}
interface Color{
    void fillColor();
}
class Red implements Color{
    @Override
    public void fillColor() {
        System.out.println("Fill RED COLOR");
    }
}
class Green implements Color{
    @Override
    public void fillColor() {
        System.out.println("Fill GREEN COLOR");
    }
}
class Blue implements Color{
    @Override
    public void fillColor() {
        System.out.println("Fill BLUE COLOR");
    }
}