package javalesson.mockitotest.bartest;

public class Bar {
    private Foo foo;
    public Bar(Foo foo) {
        this.foo = foo;
    }
     public String bar(String parametr){
        return foo.foo(parametr);
     }
}