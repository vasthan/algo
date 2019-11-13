package com.adc.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {

            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }


    public static void main(String[] args) {

        int[] arr = SortHelper.generateIntArray(20, 1000);

        System.out.println(Arrays.toString(arr));
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
