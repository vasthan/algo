package com.algo.sort;

import com.util.ArrayUtils;

public class Main {

    public static void main(String[] args) {
        // 完全随机数的测试用例
//         Integer[] arr1 = ArrayUtils.generateRandomIntArr(1000000, 0, Integer.MAX_VALUE);

        // 大量重复元素的测试用例
//        Integer[] arr1 = ArrayUtils.generateRandomIntArr(1000000, 0, 100);

        // 数据几乎有序的测试用例
        Integer[] arr1 = ArrayUtils.generateNearlyOrderedIntArr(1000000, 10);

        Integer[] arr2 = ArrayUtils.copy(arr1);
        Integer[] arr3 = ArrayUtils.copy(arr1);
        Integer[] arr4 = ArrayUtils.copy(arr1);

        double time1 = SortHelper.test(MergeSort::sort, arr1);
        System.out.println("MergeSort: " + time1 + "s");

        double time2 = SortHelper.test(QuickSortSingleWay::sort, arr2);
        System.out.println("QuickSortSingleWay: " + time2 + "s");

        double time3 = SortHelper.test(QuickSortDoubleWays::sort, arr3);
        System.out.println("QuickSortDoubleWays: " + time3 + "s");

        double time4 = SortHelper.test(QuickSortThreeWays::sort, arr4);
        System.out.println("QuickSortThreeWays: " + time4 + "s");


    }
}
