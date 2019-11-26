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

        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            doSort(arr, lo, pivot - 1);
            doSort(arr, pivot + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {

        int v = arr[lo];
        while (lo < hi) {
            while (arr[hi] >= v && lo < hi) {
                hi--;
            }
            arr[lo] = arr[hi];
            while (arr[lo] <= v && lo < hi) {
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[lo] = v;
        return lo;
    }


}
