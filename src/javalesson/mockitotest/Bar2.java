package javalesson.mockitotest;

public class Bar2 {
    private Foo foo1;
    private Foo foo2;

    public Bar2(Foo foo1, Foo foo2) {
        this.foo1 = foo1;
        this.foo2 = foo2;
    }

    public void bar(String parametr){
        foo1.foo(parametr);
        foo2.foo(parametr);
    }

}
