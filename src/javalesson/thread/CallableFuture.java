package javalesson.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("1 " + futureTask.get());
    }

    static  class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 10; i++, j++) {
                Thread.sleep(1000);
                System.out.println(i);
            }

            return j;
        }
    }
}
