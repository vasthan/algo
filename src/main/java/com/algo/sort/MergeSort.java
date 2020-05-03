package com.algo.sort;

import com.util.ArrayUtils;

import java.util.Arrays;

public class MergeSort {

    // 自顶向下归并
    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // 自底向上归并
    public static void sortBottomUp(Comparable[] arr) {
        int n = arr.length;
        // 每次归并的数组大小：1、2、4、8，和自顶向下归并的递归过程相反
        for (int size = 1; size < n; size += size) {
            // 对arr[i, i + size - 1] 和 arr[i + size, i + 2*size - 1] 进行归并
            for (int i = 0; i + size < n; i += 2 * size) {
                merge(arr, i, i + size - 1, Math.min(n - 1, i + 2 * size - 1));
            }
        }
    }

    // 对[l, r]区间的数组元素进行归并排序，递归
    private static void mergeSort(Comparable[] arr, int l, int r) {
        // 优化2：当数组小于一定长度时，使用插入排序，要看实际情况吧，本机测试1000万数据量，用插入排序反而慢了，不知道为什么
        // if (r - l < 15)  {
        //     insertionSort(arr, l, r);
        // }

        if (l >= r) {
            return;
        }

        // int mid = (l + r) / 2; // 存在溢出可能
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        // 优化1：如果[l, mid]区间的最大元素小于[mid+1, r]区间的最小元素，表示整个数组已经有序，否则才需要merge
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    // 对[l, mid]区间和[mid+1, r]区间的数组元素进行合并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        // 开辟临时空间
        Comparable[] tmp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = tmp[j - l];j++;
            } else if (j > r) {
                arr[k] = tmp[i - l];i++;
            } else if (tmp[i - l].compareTo(tmp[j - l]) < 0) {
                arr[k] = tmp[i - l];i++;
            } else {
                arr[k] = tmp[j - l];j++;
            }
        }
    }

    private static void insertionSort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(arr[j]) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayUtils.generateRandomIntArr(1000000, 0, Integer.MAX_VALUE);
        double time = SortHelper.test(MergeSort::sort, arr);
        System.out.println(time + "s");
    }
}
