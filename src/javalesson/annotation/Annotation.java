package javalesson.annotation;

import java.beans.Transient;
import java.lang.annotation.*;

public class Annotation {
    public static void main(String[] args) {

    }
}

@Deprecated
@MyAnn("someValue")
//@MyAnn(i = 5, run = false)
class MyClass{
    @Deprecated
    int i;

    @Deprecated
    MyClass(){

    }

    @Transient
    @Deprecated
    public void method(@Deprecated int i){
        @Deprecated
        int j;
    }
}
class Myclass2 extends MyClass{

}

@Retention(RetentionPolicy.CLASS)
//@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Inherited
@interface MyAnn{
    boolean run() default true;
    int i() default 1;
    String value();
}
// BugReport