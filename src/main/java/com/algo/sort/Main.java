package com.algo.sort;

import com.util.ArrayUtils;

public class Main {

    public static void main(String[] args) {
        // Integer[] arr = ArrayUtils.generateRandomIntArr(50000, 0, Integer.MAX_VALUE);
        Integer[] arr = ArrayUtils.generateNearlyOrderedIntArr(10000000, 100);
        Integer[] arr2 = ArrayUtils.copy(arr);
        Integer[] arr3 = ArrayUtils.copy(arr);

        double time1 = SortHelper.test(InsertionSortOptimize::sort, arr);
        System.out.println("InsertionSort optimize: " + time1 + "s");

        double time2 = SortHelper.test(MergeSort::sort, arr2);
        System.out.println("MergeSort: " + time2 + "s");

        double time3 = SortHelper.test(MergeSort::sortBottomUp, arr3);
        System.out.println("MergeSortBottomUp: " + time3 + "s");
    }
}
