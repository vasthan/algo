package com.algo.sort;

import com.util.ArrayUtils;

/*
冒泡排序优化：
1、如果某一次排序过程没有发生元素交换，表示已经排好序了，终止循环
2、每一趟冒泡都将最大的元素放到了最后的位置，所以下一趟排序，可以不再考虑最后已经拍好序的元素
 */
public class BubbleSort {

    public static void sort(Comparable[] arr) {
        boolean swapped;
        int n = arr.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    ArrayUtils.swap(arr, i - 1, i);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

    }

    public static void main(String[] args) {
        Integer[] arr = ArrayUtils.generateRandomIntArr(10000, 0, Integer.MAX_VALUE);
        double time = SortHelper.test(BubbleSort::sort, arr);
        System.out.println(time + "s");
    }
}
