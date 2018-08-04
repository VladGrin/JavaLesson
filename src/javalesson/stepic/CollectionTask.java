package javalesson.stepic;

import java.util.*;

public class CollectionTask {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (scanner.hasNextInt()){
            if ((i++ % 2 != 0)) {
                stack.push(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

