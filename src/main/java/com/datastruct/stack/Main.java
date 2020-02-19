package com.datastruct.stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> linkedStack = new LinkedListStack<>();

        int opCount = 1000000;
        double time1 = testStack(arrayStack, opCount);
        double time2 = testStack(linkedStack, opCount);

        System.out.println(time1 + "s");
        System.out.println(time2 + "s");
    }


    private static double testStack(Stack<Integer> stack, int opCount) {
        long start = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            stack.push(i);
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
}
