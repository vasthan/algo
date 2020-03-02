package com.algo.sort;

import com.util.ArrayUtils;

import java.util.Random;

public class QuickSort {

    private static Random random = new Random();

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            sort(arr, l, pivot - 1);
            sort(arr, pivot + 1, r);
        }
    }

    private static int partition(Comparable[] arr, int l, int r) {
        // 随机取基准
        ArrayUtils.swap(arr, l, random.nextInt(r - l + 1) + l);
        Comparable v = arr[l];
        // 设置头尾两个哨兵，从两边到中间移动
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j].compareTo(v) >= 0) {
                j--;
            }
            while (i < j && arr[i].compareTo(v) <= 0) {
                i++;
            }
            ArrayUtils.swap(arr, i, j);
        }
        ArrayUtils.swap(arr, l , j);
        return j;
    }
}
