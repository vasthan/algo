package com.algo.sort;

import com.util.ArrayUtils;

import java.util.Random;

// 三路快速排序，适合对具有重复元素的数组进行排序，性能极高
public class QuickSortThreeWays {

    private static Random random = new Random();

    public static void sort(Comparable[] arr) {

        sort(arr, 0, arr.length -1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        ArrayUtils.swap(arr, l, random.nextInt(r - l + 1) + l);
        Comparable v = arr[l]; // 基准点

        // [l + 1, lt] < v, (lt, gt) = v, [gt, r] > v
        int lt = l;
        int gt = r + 1;
        int i = l + 1;

        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                ArrayUtils.swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                ArrayUtils.swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        ArrayUtils.swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }
}
