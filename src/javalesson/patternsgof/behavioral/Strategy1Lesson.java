package javalesson.patternsgof.behavioral;

public class Strategy1Lesson {
    public static void main(String[] args) {
        DeveloperNewOne developer = new DeveloperNewOne();

        developer.setActivityNew(new SleepingNew());
        developer.executeActivity();

        developer.setActivityNew(new TrainingNew());
        developer.executeActivity();

        developer.setActivityNew(new CodingNew());
        developer.executeActivity();

        developer.setActivityNew(new ReadingNew());
        developer.executeActivity();
    }
}
interface ActivityNew{
    void justDoIt();
}
class CodingNew implements ActivityNew{

    @Override
    public void justDoIt() {
        System.out.println("Coding...");
    }
}
class ReadingNew implements ActivityNew{

    @Override
    public void justDoIt() {
        System.out.println("Reading...");
    }
}
class SleepingNew implements ActivityNew{

    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}
class TrainingNew implements ActivityNew{

    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}
class DeveloperNewOne{
    ActivityNew activityNew;

    public void setActivityNew(ActivityNew activityNew) {
        this.activityNew = activityNew;
    }

    public void executeActivity(){
        activityNew.justDoIt();
    }
}