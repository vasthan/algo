package com.adc.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > v; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr = SortHelper.generateIntArray(20, 1000);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
