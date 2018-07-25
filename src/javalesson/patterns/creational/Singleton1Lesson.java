package javalesson.patterns.creational;

public class Singleton1Lesson {
    public static void main(String[] args) {
        ProgramLogger.getProgramLogger().addLogInfo("First log.");
        ProgramLogger.getProgramLogger().addLogInfo("Second log.");
        ProgramLogger.getProgramLogger().addLogInfo("Third log.");
        ProgramLogger.getProgramLogger().showLogFile();

    }
}
class ProgramLogger{
    private static ProgramLogger programLogger;
    private static String logFile = "This is log File. \n\n";

    public static synchronized ProgramLogger getProgramLogger(){
        if(programLogger ==null){
            programLogger = new ProgramLogger();
        }
        return programLogger;
    }

    private ProgramLogger() {
    }

    public void addLogInfo(String logInfo){
        logFile += logInfo + "\n";
    }
    public void showLogFile(){
        System.out.println(logFile);
    }
}