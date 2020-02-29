package com.datastruct.heap;

import java.util.Random;

public class Main {

    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long start = System.nanoTime();

        MaxHeap<Integer> heap;
        if (isHeapify) {
            heap = new MaxHeap<>(testData);
        } else {
            heap = new MaxHeap<>();
            for (Integer num : testData) {
                heap.add(num);
            }
        }

        // int[] arr = new int[testData.length];
        // for (int i = 0; i < testData.length; i++) {
        //     arr[i] = heap.extractMax();
        // }
        //
        // for (int i = 1; i < arr.length; i++) {
        //     if (arr[i - 1] < arr[i]) {
        //         throw new IllegalArgumentException("error");
        //     }
        // }
        System.out.println("Test HeapMap completed!");

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    // 测试heapify的时间复杂度
    public static void main(String[] args) {

        Random random = new Random();
        int n = 10000000;
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData, true);
        System.out.println("with heapify: " + time1);

        double time2 = testHeap(testData, false);
        System.out.println("without heapify: " + time2);

    }
}
