package com.algo.sort;

import com.util.ArrayUtils;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = ArrayUtils.generateRandomIntArr(100000, 0, Integer.MAX_VALUE);
        Integer[] arr2 = ArrayUtils.copy(arr);

        double time1 = SortHelper.test(SelectionSort::sort, arr);
        System.out.println("Selection sort: " + time1 + "s");

        double time2 = SortHelper.test(InsertionSort::sort, arr2);
        System.out.println("Insertion sort: " + time2 + "s");
    }
}
