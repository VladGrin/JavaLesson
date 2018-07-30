package javalesson.stepic;

public class ExeptionTask3 {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] elements = new Exception().getStackTrace();
        if (elements.length < 3 ) {
            return null;
        } else {
            return elements[2].getClassName()+"#"+elements[2].getMethodName();
        }
    }
}
