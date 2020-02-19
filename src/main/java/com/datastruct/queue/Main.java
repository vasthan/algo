package com.datastruct.queue;

import java.util.Random;

/**
 * 测试ArrayQueue和LoopQueue的算法性能
 * ArrayQueue的出栈操作是O(n)复杂度，而LoopQueue的出栈操作是O(1)复杂度
 */
public class Main {

    public static void main(String[] args) {
        int opCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);

        Queue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);

        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);

        System.out.println("time1: " + time1);
        System.out.println("time2: " + time2);
        System.out.println("time3: " + time3);
    }


    private static double testQueue(Queue queue, int opCount) {
        long start = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }
}
