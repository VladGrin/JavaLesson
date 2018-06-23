package javalesson.solid;

public class LiskovSubstitutionPrinciple {
    static Rectangle getRectangle(){
        return new Rectangle();
        //return new Square();
    }

    public static void main(String[] args) {
        Rectangle rectangle = getRectangle();
        rectangle.setHeight(10);
        rectangle.setWidth(5);
        System.out.println(rectangle.getSquare());
    }
}
interface Shape{
    int getSquare();
}
class Rectangle implements Shape{
    int width;
    int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public int getSquare(){
        return width*height;
    }
}
class Square implements Shape{
//    public void setWidth(int width) {
//        this.width = width;
//        height = width;
//    }
//    public void setHeight(int height) {
//        this.height = height;
//        width = height;
//    }
    int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getSquare() {
        return width*width;
    }
}