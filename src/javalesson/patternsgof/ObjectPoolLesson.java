package javalesson.patternsgof;

import java.util.LinkedList;
import java.util.List;

public class ObjectPoolLesson {
    public static void main(String[] args) {
        MyPool myPool = new MyPool();
        MyObject myObject = myPool.getMyObject();
        myPool.releaseMyObject(myObject);
    }
}
class MyObject{

}
class MyPool{
    List<MyObject> free = new LinkedList<>();
    List<MyObject> used = new LinkedList<>();
    public MyObject getMyObject(){
        if(free.isEmpty()){
            MyObject myObject = new MyObject();
            free.add(myObject);
            return myObject;
        } else {
            MyObject myObject = free.get(0);
            used.add(myObject);
            free.remove(myObject);
            return myObject;
        }
    }
    public void releaseMyObject(MyObject myObject){
        used.remove(myObject);
        free.add(myObject);
    }

}