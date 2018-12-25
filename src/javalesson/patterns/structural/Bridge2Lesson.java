package javalesson.patterns.structural;

public class Bridge2Lesson {
    public static void main(String[] args) {
        Toy toy1 = new Heer(new WoodToy());
        toy1.getToy();
        Toy toy2 = new Wolf(new WoodToy());
        toy2.getToy();
        Toy toy3 = new Heer(new SoftToy());
        toy3.getToy();
        Toy toy4 = new Wolf(new SoftToy());
        toy4.getToy();
    }
}
abstract class Toy{
    Material material;

    public Toy(Material material) {
        this.material = material;
    }

    abstract void getToy();
}
class Heer extends Toy{
    public Heer(Material material) {
        super(material);
    }

    @Override
    void getToy() {
        System.out.print("Hare ");
        material.getMaterial();
    }
}
class Wolf extends Toy{
    public Wolf(Material material) {
        super(material);
    }

    @Override
    void getToy() {
        System.out.print("Wolf ");
        material.getMaterial();
    }
}
interface Material{
    void getMaterial();
}
class WoodToy implements Material{
    @Override
    public void getMaterial() {
        System.out.println("WoodToy");
    }
}
class SoftToy implements Material{
    @Override
    public void getMaterial() {
        System.out.println("SoftToy");
    }
}