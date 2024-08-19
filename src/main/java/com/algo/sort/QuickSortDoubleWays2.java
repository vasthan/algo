package com.algo.sort;

import com.util.ArrayUtils;

/**
 * 双路快排：适用于存在大量重复元素的数组排序
 * 重复元素可以分摊到左右分区中，递归树更平衡
 * https://coding.imooc.com/lesson/71.html#mid=1460
 */
public class QuickSortDoubleWays2 {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 对数组的[l, r]区间进行快速排序
     */
    private static void quickSort(Comparable[] arr, int l, int r) {
        // 递归终止条件，数组元素个数小于等于1
        if (l >= r) {
            return;
        }
        // 将数组分成左右两部分，左半部分[l, m-1]区间的元素都小于等于arr[m]，右半部分[m+1, r]区间的元素都大于等于arr[m]
        int m = partition(arr, l, r);
        // 对两个子数组分别进行排序
        quickSort(arr, l, m - 1);
        quickSort(arr, m + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];

        // [l+1, i)区间的元素小于等于v，(j, r]区间的元素大于等于v
        int i = l + 1, j = r;
        while (i <= j) {
            // i指针不断右移，直到找到一个大于等于v的元素
            while (i <= j && arr[i].compareTo(v) < 0) {
                i++;
            }
            // j指针不断左移，直到找到一个小于等于v的元素
            while (i <= j && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i <= j) {
                ArrayUtils.swap(arr, i, j);
                i++;
                j--;
            }
        }
        ArrayUtils.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        // 随机数
        Integer[] arr1 = ArrayUtils.generateRandomIntArr(1000000, 0, Integer.MAX_VALUE);
        Integer[] arr1Copy = ArrayUtils.copy(arr1);
        System.out.println("随机数组测试：");

        double cost2 = SortHelper.test(QuickSortDoubleWays2::sort, arr1Copy);
        System.out.println("双路快排2: " + cost2);

        double cost1 = SortHelper.test(QuickSortDoubleWays::sort, arr1);
        System.out.println("双路快排1: " + cost1);


        // 大量重复元素
        Integer[] arr2 = ArrayUtils.generateRandomIntArr(1000000, 0, 100);
        Integer[] arr2Copy = ArrayUtils.copy(arr2);
        System.out.println("大量重复元素数组测试：");

        cost2 = SortHelper.test(QuickSortDoubleWays2::sort, arr2Copy);
        System.out.println("双路快排2: " + cost2);

        cost1 = SortHelper.test(QuickSortDoubleWays::sort, arr2);
        System.out.println("双路快排1: " + cost1);

    }
}
