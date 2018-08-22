package javalesson.mockitotest;

public class BarVoid {
    private FooVoid foo;

    public BarVoid(FooVoid foo) {
        this.foo = foo;
    }

    public void bar(String parametr){
        foo.foo(parametr);
    }
}

