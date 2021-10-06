package com.algo.sort;

import com.util.ArrayUtils;

import java.util.Random;

// 三路快速排序，适合对具有重复元素的数组进行排序，性能极高
public class QuickSortThreeWays {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 随机选择基准点
        int k = new Random().nextInt(r - l + 1) + l;
        ArrayUtils.swap(arr, l, k);
        Comparable v = arr[l];

        // 把数组一分为三：[l + 1, p], [p + 1, q - 1], [q, r]
        // [l + 1, p]区间元素 < v
        // [p + 1, q - 1]区间元素 = v
        // [q, r]区间元素 > v
        int p = l, q = r + 1;
        int i = l + 1;
        while (i < q) {
            if (arr[i].compareTo(v) < 0) {
                ArrayUtils.swap(arr, i, p + 1);
                p++;
                i++;
            } else if (arr[i].compareTo(v) > 0) {
                ArrayUtils.swap(arr, i, q - 1);
                q--;
            } else {
                i++;
            }
        }
        ArrayUtils.swap(arr, l, p);
        quickSort(arr, l, p - 1);
        quickSort(arr, q, r);
    }

    public static void main(String[] args) {
        // 随机数
        Integer[] arr1 = ArrayUtils.generateRandomIntArr(1000000, 0, Integer.MAX_VALUE);
        // 大量重复元素
        Integer[] arr2 = ArrayUtils.generateRandomIntArr(1000000, 0, 100);

        System.out.println("随机数组测试：");
        double cost1 = SortHelper.test(QuickSortSingleWay::sort, arr1);
        System.out.println("单路快排: " + cost1);
        double cost2 = SortHelper.test(QuickSortDoubleWays::sort, arr1);
        System.out.println("双路快排: " + cost2);
        double cost3 = SortHelper.test(QuickSortThreeWays::sort, arr1);
        System.out.println("三路快排: " + cost3);

        System.out.println("大量重复元素数组测试：");
        cost1 = SortHelper.test(QuickSortSingleWay::sort, arr2);
        System.out.println("单路快排: " + cost1);
        cost2 = SortHelper.test(QuickSortDoubleWays::sort, arr2);
        System.out.println("双路快排1: " + cost2);
        cost3 = SortHelper.test(QuickSortThreeWays::sort, arr2);
        System.out.println("三路快排: " + cost3);
    }


}
