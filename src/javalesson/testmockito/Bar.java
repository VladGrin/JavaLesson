package javalesson.testmockito;

public class Bar {
    private Foo foo;
    public Bar(Foo foo) {
        this.foo = foo;
    }
     public String bar(String parametr){
        return foo.foo(parametr);
     }
}
interface Foo{
    String foo(String parameter);
}
class FooImpl implements Foo{
    @Override
    public String foo(String parameter) {
        return parameter;
    }
}
