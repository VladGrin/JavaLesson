package javalesson.patterns;

public class VisitorApp {
    public static void main(String[] args) {
        Element engineElement = new EngineElement();
        Element bodyElement = new BodyElement();
        Visitor visitor = new GoodVisitir();
        engineElement.accept(visitor);
        bodyElement.accept(visitor);
    }
}
interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
}
interface Element{
    void accept(Visitor visitor);
}
class EngineElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class BodyElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class BadVisitir implements Visitor{

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Break engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Scrept body");
    }
}
class GoodVisitir implements Visitor{

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Fix engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Paint body");
    }
}