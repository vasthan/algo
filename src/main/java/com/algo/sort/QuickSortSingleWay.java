package com.algo.sort;

import com.util.ArrayUtils;

import java.util.Random;

/**
 * 单路快排，快排的最基本实现（适用于数组完全随机的情况）
 */
public class QuickSortSingleWay {

    public static <T> void sort(Comparable<T>[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        // 递归终止条件，待排序的[l, r]区间长度小于等于1
        if (l >= r) {
            return;
        }
        // 对[l, r]区间进行分区，返回p，使得arr[l, p-1] < arr[p], arr[p+1, r] >= arr[p]
        // 如果数组含有大量重复元素，会导致分割不均匀，递归树的高度不平衡
        // 极端情况下，树会退化为链表，快排的时间复杂度从O(nlogn)上升为O(n^2) ，甚至会导致递归栈溢出
        int p = partition(arr, l, r);

        // 递归对分割的两个子数组进行排序
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        // 随机选择基准点，k的取值范围是[l, r]
        int k = new Random().nextInt(r - l + 1) + l;
        ArrayUtils.swap(arr, l, k);

        Comparable v = arr[l];

        // 下标定义：[l + 1, j] < v, [j + 1, i) >= v, i是当前遍历到的元素
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                ArrayUtils.swap(arr, i, j + 1);
                j++;
            }
        }
        ArrayUtils.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        // 随机数
        Integer[] arr1 = ArrayUtils.generateRandomIntArr(1000000, 0, Integer.MAX_VALUE);
        // 大量重复元素
        Integer[] arr2 = ArrayUtils.generateRandomIntArr(1000000, 0, 100);

        double cost1 = SortHelper.test(QuickSortSingleWay::sort, arr1);
        System.out.println(cost1);
        double cost2 = SortHelper.test(QuickSortSingleWay::sort, arr2);
        System.out.println(cost2);
    }
}
