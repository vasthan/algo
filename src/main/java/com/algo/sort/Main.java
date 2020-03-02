package com.algo.sort;

import com.util.ArrayUtils;

public class Main {

    public static void main(String[] args) {
        // Integer[] arr1 = ArrayUtils.generateRandomIntArr(1000000, 0, Integer.MAX_VALUE);
        Integer[] arr1 = ArrayUtils.generateRandomIntArr(1000000, 0, 100);
        // Integer[] arr1 = ArrayUtils.generateNearlyOrderedIntArr(1000000, 10);
        Integer[] arr2 = ArrayUtils.copy(arr1);
        Integer[] arr3 = ArrayUtils.copy(arr1);

        double time1 = SortHelper.test(MergeSort::sort, arr1);
        System.out.println("MergeSort: " + time1 + "s");

        double time2 = SortHelper.test(QuickSort::sort, arr2);
        System.out.println("QuickSort: " + time2 + "s");

        double time3 = SortHelper.test(QuickSortThreeWays::sort, arr3);
        System.out.println("QuickSortThreeWays: " + time3 + "s");
    }
}
