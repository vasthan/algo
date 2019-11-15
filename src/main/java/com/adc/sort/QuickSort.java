package com.adc.sort;

import java.util.Arrays;

/**
 * 快速排序基础版本
 * 讲解：https://juejin.im/post/5b02b22f6fb9a07a9d70a501
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = SortHelper.generateIntArray(10, 100);
        System.out.println(Arrays.toString(arr));

        QuickSort.sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr, int n) {
        sortInternal(arr, 0, n -1);
    }

    private static void sortInternal(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            sortInternal(arr, l, pivot - 1);
            sortInternal(arr, pivot + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int base = arr[l];

        while (l < r) {
            while (l < r && arr[r] >= base) {
                r--;
            }
            arr[l] = arr[r];

            while (l < r && arr[l] <= base) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = base;
        return l;
    }
}
