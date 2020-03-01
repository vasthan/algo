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
        InsertionSort.sort(arr);
        SortHelper.isSorted(arr);
    }
}
