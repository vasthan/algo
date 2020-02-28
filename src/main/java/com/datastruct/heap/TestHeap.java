package com.datastruct.heap;

import java.util.Random;

public class TestHeap {

    public static void main(String[] args) {

        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        int n = 1000000;
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("Test HeapMap completed!");
    }
}
