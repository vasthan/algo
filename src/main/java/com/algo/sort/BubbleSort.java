package com.algo.sort;

import com.util.ArrayUtils;

public class BubbleSort {

    public static void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    ArrayUtils.swap(arr, j - 1, j);
                    swap = true;
                }
            }
            if (!swap) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayUtils.generateRandomIntArr(10000, 0, Integer.MAX_VALUE);
        double time = SortHelper.test(BubbleSort::sort, arr);
        System.out.println(time + "s");
    }
}
