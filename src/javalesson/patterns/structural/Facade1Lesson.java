package javalesson.patterns.structural;

public class Facade1Lesson {
    public static void main(String[] args) {
        Workflow workflow = new Workflow();
        workflow.solveProblems();
    }
}
class Workflow{
    private Job job = new Job();
    private BugTracker bugTracker = new BugTracker();
    private DeveloperF developerF = new DeveloperF();
    public void solveProblems(){
        job.doJob();
        bugTracker.startSprint();
        developerF.doJobBeforeDeadLine(bugTracker);

        bugTracker.finishSprint();
        developerF.doJobBeforeDeadLine(bugTracker);
    }
}
class Job{
    void doJob(){
        System.out.println("Job in progress...");
    }
}
class BugTracker{
    private boolean activeSprint;
    public boolean isActiveSprint() {
        return activeSprint;
    }
    public void startSprint(){
        System.out.println("Sprint is active.");
        activeSprint = true;
    }
    public void finishSprint(){
        System.out.println("Sprint is not active.");
        activeSprint = false;
    }
}
class DeveloperF{
    public void doJobBeforeDeadLine(BugTracker bugTacker){
        if(bugTacker.isActiveSprint()){
            System.out.println("Developer is solving problems...");
        }else{
            System.out.println("Developer is reading Habrahabr...");
        }
    }
}