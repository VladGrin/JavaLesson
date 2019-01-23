package javalesson.patternsgof.behavioral;

public class State1Lesson {
    public static void main(String[] args) throws InterruptedException {
        Activity activity = new Sleeping();
        DeveloperNew developerNew = new DeveloperNew();

        developerNew.setActivity(activity);
        for (int i = 0; i < 10; i++) {
            developerNew.jostDoIt();
            developerNew.changeActivity();
            Thread.sleep(2000);
        }
    }
}
interface Activity{
    void justDoIt();
}
class Coding implements Activity{

    @Override
    public void justDoIt() {
        System.out.println("Writing cod...");
    }
}
class Reading implements Activity{

    @Override
    public void justDoIt() {
        System.out.println("Reading book...");
    }
}
class Sleeping implements Activity{

    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}
class Training implements Activity{

    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}
class DeveloperNew{
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void changeActivity(){
        if (activity instanceof Sleeping){
            setActivity(new Training());
        } else if (activity instanceof Training){
            setActivity(new Coding());
        } else if(activity instanceof Coding){
            setActivity(new Reading());
        } else if (activity instanceof Reading){
            setActivity(new Sleeping());
        }
    }
    public void jostDoIt(){
        activity.justDoIt();
    }
}
