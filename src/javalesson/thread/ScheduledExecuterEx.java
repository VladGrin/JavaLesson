package javalesson.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecuterEx {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new MyTread(), 5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

    static class MyTread extends Thread {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
