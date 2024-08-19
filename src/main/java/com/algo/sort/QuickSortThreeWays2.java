package com.algo.sort;

import com.util.ArrayUtils;

// 三路快速排序，适合对具有重复元素的数组进行排序，性能极高
public class QuickSortThreeWays2 {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 对[l, r]区间进行三路排序
     */
    private static void quickSort(Comparable[] arr, int l, int r) {
        // 写递归方法的第一件事，递归的终止条件判断！！！
        if (l >= r) {
            return;
        }
        // lt, gt
        // [l+1, lt]的元素小于v
        // [gt, r]的元素大于v

        // 变量初始值定义，让上面两个区间初始化时都为空
        int lt = l;
        int gt = r + 1;

        Comparable v = arr[l];
        // 从l+1开始遍历，当i碰到gt时循环结束
        int i = l + 1;
        while (i < gt) {
            if (arr[i].compareTo(v) == 0) {
                i++;
            } else if (arr[i].compareTo(v) < 0) {
                ArrayUtils.swap(arr, i, lt + 1);
                lt++;
                i++;
            } else {
                ArrayUtils.swap(arr, i, gt - 1);
                gt--;
            }
        }
        ArrayUtils.swap(arr, l, lt);
        // 继续分别对[l, lt - 1]和[gt, r]区间进行三路排序
        quickSort(arr, l, lt - 1);
        quickSort(arr, gt, r);

    }

    public static void main(String[] args) {
        // 随机数
        Integer[] arr1 = ArrayUtils.generateRandomIntArr(1000000, 0, Integer.MAX_VALUE);
        Integer[] arr2 = ArrayUtils.copy(arr1);

        System.out.println("随机数组测试：");
        double cost = SortHelper.test(QuickSortDoubleWays::sort, arr1);
        System.out.println("双路快排: " + cost);
        cost = SortHelper.test(QuickSortThreeWays2::sort, arr2);
        System.out.println("三路快排: " + cost);

        // 大量重复元素
        arr1 = ArrayUtils.generateRandomIntArr(1000000, 0, 100);
        arr2 = ArrayUtils.copy(arr1);

        System.out.println("大量重复元素数组测试：");
        cost = SortHelper.test(QuickSortDoubleWays::sort, arr1);
        System.out.println("双路快排: " + cost);
        cost = SortHelper.test(QuickSortThreeWays2::sort, arr2);
        System.out.println("三路快排: " + cost);
    }


}
