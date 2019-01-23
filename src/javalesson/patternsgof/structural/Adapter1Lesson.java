package javalesson.patternsgof.structural;

public class Adapter1Lesson {
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();
        database.insert();
        database.update();
        database.select();
        database.remove();
    }
}
interface Database{
    void insert();
    void update();
    void select();
    void remove();
}
class JavaApplication{
    void saveObject(){
        System.out.println("Saving Java Object ...");
    }
    void updateObject(){
        System.out.println("Updating Java Object ...");
    }
    void loadObject(){
        System.out.println("Loading Java Object ...");
    }
    void deleteObject(){
        System.out.println("Deleting Java Object ...");
    }
}
class AdapterJavaToDatabase extends JavaApplication implements Database{

    @Override
    public void insert() {
        saveObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void select() {
        loadObject();
    }

    @Override
    public void remove() {
        deleteObject();
    }
}