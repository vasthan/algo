package com.algo.sort;

// 插入排序优化
public class InsertionSortOptimize {

    public static void sort(Comparable[] arr) {

        for (int i = 1; i < arr.length; i++) {
            // 记录当前待插入的元素
            Comparable e = arr[i];
            // 记录当前元素应该插入的位置
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
