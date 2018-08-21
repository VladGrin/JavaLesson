package javalesson.jmxlesson;

class Hello implements HelloMBean{
    private String name;

    @Override
    public void sayHello() {
        System.out.println("Hello from JMX");
    }

    @Override
    public int addIntegers(int a, int b) {
        return a+ b;
    }

    @Override
    public Person getPerson() {
        return new Person();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName() {
        this.name = name;
    }
}
