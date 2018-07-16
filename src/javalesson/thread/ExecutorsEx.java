package javalesson.thread;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsEx  {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 500; i++) {
            executorService.submit(new MyRunnable());
        }
        for (int i = 0; i < 500; i++) {
            System.out.println(executorService.submit(new MyCallable()).get());
        }
        executorService.shutdown();
        ExecutorService executorService1 = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 500; i++) {
            executorService1.submit(new MyRunnable());
        }
        for (int i = 0; i < 500; i++) {
            System.out.println(executorService1.submit(new MyCallable()).get());
        }
        executorService1.shutdown();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
    volatile static int k = 0;
    static class MyRunnable implements Runnable{


        @Override
        public void run() {
            System.out.println(k++);
        }
    }
    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return k++;
        }
    }
}
