package javalesson.patterns;

import java.util.*;

public class FlyweightApp {
    public static void main(String[] args) {
        MyShapeFactory myShapeFactory = new MyShapeFactory();
        List<MyShape> shapes = new ArrayList<>();
        shapes.add(myShapeFactory.getMyShape("square"));
        shapes.add(myShapeFactory.getMyShape("circle"));
        shapes.add(myShapeFactory.getMyShape("circle"));
        shapes.add(myShapeFactory.getMyShape("point"));
        shapes.add(myShapeFactory.getMyShape("square"));
        shapes.add(myShapeFactory.getMyShape("circle"));

        Random random = new Random();
        for(MyShape myShape : shapes){
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            myShape.draw(x, y);
        }
    }
}
interface MyShape{
    void draw(int x, int y);
}
class MyPoint implements MyShape{

    @Override
    public void draw(int x, int y) {
        System.out.println("Draw point:x= " + x + ", y= " + y);
    }
}
class MyCircle implements MyShape{
    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("Draw circle:x= " + x + ", y= " + y + ", r= " + r);
    }
}
class MySquare implements MyShape{
    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("Draw square:x= " + x + ", y= " + y + ", a= " + a);
    }
}
class MyShapeFactory{
    private final static Map<String, MyShape> shapes = new HashMap<>();
    MyShape getMyShape(String shapeName){
        MyShape myShape = shapes.get(shapeName);
        if(myShape == null){
            switch (shapeName){
                case "circle" : myShape = new MyCircle(); break;
                case "square" : myShape = new MySquare(); break;
                case "point" : myShape = new MyPoint(); break;
            }
            shapes.put(shapeName, myShape);
        }
        return myShape;
    }
}