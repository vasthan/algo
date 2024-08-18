package com.algo.sort;

import com.util.ArrayUtils;

public class InsertionSort {

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1].compareTo(arr[j]) < 0) {
                    break;
                }
                ArrayUtils.swap(arr, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayUtils.generateRandomIntArr(10000, 0, 10000);
        InsertionSort.sort2(arr);
        boolean sorted = SortHelper.isSorted(arr);
        System.out.println(sorted);
    }


    public static void sort2(Integer[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    ArrayUtils.swap(arr, j, j - 1);
                }
            }
        }
    }
}
