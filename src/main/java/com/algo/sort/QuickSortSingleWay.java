package com.algo.sort;

import com.util.ArrayUtils;

import java.util.Random;

/**
 * 单路快排，一个指针
 */
public class QuickSortSingleWay {
    private static Random random = new Random();

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    // [l + 1, j]区间元素小于v，[j + 1, i]区间元素大于v
    private static int partition(Comparable[] arr, int l, int r) {
        // 随机选择基准元素并交换至最左边
        ArrayUtils.swap(arr, l, random.nextInt(r - l + 1) + l);
        Comparable v = arr[l];
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if (arr[i].compareTo(v) <= 0) {
                ArrayUtils.swap(arr, ++j, i);
            }
        }
        ArrayUtils.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayUtils.generateRandomIntArr(1000000, 0, Integer.MAX_VALUE);
        double cost = SortHelper.test(QuickSortSingleWay::sort, arr);
        System.out.println(cost);
    }
}
