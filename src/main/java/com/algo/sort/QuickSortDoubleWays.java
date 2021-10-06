package com.algo.sort;

import com.util.ArrayUtils;

import java.util.Random;

/**
 * 双路快排：适用于存在大量重复元素的数组排序
 * 重复元素可以分摊到左右分区中，递归树更平衡
 * https://coding.imooc.com/lesson/71.html#mid=1460
 */
public class QuickSortDoubleWays {

    public static void sort(Comparable[] arr) {
        if (arr == null) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    private static int partition(Comparable[] arr, int l, int r) {
        // 随机选择基准点
        int k = new Random().nextInt(r - l + 1) + l;
        ArrayUtils.swap(arr, l, k);
        Comparable v = arr[l];

        // 双指针对撞分区，[l + 1, i)区间元素小于等于v，(j, r]区间元素大于等于v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            ArrayUtils.swap(arr, i, j);
            i++;
            j--;
        }
        ArrayUtils.swap(arr, l, j);
        return j;
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

        System.out.println("大量重复元素数组测试：");
        cost1 = SortHelper.test(QuickSortSingleWay::sort, arr2);
        System.out.println("单路快排: " + cost1);
        cost2 = SortHelper.test(QuickSortDoubleWays::sort, arr2);
        System.out.println("双路快排: " + cost2);
    }
}
