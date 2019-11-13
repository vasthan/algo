package com.adc.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            int e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int[] arr = SortHelper.generateIntArray(20, 1000);
        System.out.println(Arrays.toString(arr));
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
