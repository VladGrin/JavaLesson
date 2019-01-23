package javalesson.patterns;

public class ProxyApp {
    public static void main(String[] args) {
        Image image = new ProxyImage("D:/image.jpg");
//        image.display();
    }
}
interface Image{
    void display();
}
class RealImage implements Image{
    String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }
    void load(){
        System.out.println("Loading " + file);
    }

    @Override
    public void display() {
        System.out.println("Watch " + file);
    }
}
class ProxyImage implements Image{
    String file;
    RealImage realImage;

    public ProxyImage(String file) {
        this.file = file;
    }
    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(file);
        }
        realImage.display();
    }
}