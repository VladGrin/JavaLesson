package javalesson.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GarbageCollector {
    public static void main(String[] args) {
        method();
    }

    private static void method() {
        GarbageCollector garbageCollector = new GarbageCollector();
        garbageCollector = null;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total memory before " + runtime.totalMemory());
        System.out.println("Free memoty before " + runtime.freeMemory());
        //List<Date> dates = new ArrayList<>(1_000_000_0);
        for (int i = 0; i < 1_000_000_00; i++) {
            Date date = new Date();
            //dates.add(date);
            date = null;
        }
        System.out.println("Total memory after " + runtime.totalMemory());
        System.out.println("Free memoty after " + runtime.freeMemory());
        System.gc();
        System.out.println("Total memory after gc" + runtime.totalMemory());
        System.out.println("Free memoty after gc " + runtime.freeMemory());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("AAAAAAAAAAAAAAAAAA");
    }
}
