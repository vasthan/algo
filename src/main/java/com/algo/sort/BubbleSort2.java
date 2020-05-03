package com.algo.sort;

import com.util.ArrayUtils;

/**
 * {@link BubbleSort} 的另一个优化版本
 */
public class BubbleSort2 {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
        int newn;
        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    ArrayUtils.swap(arr, i - 1, i);
                    newn = i;
                }
            }
            n = newn;
        } while (n > 0);

    }

    public static void main(String[] args) {
        Integer[] arr1 = ArrayUtils.generateRandomIntArr(50000, 0, Integer.MAX_VALUE);
        Integer[] arr2 = ArrayUtils.copy(arr1);
        double time1 = SortHelper.test(BubbleSort::sort, arr1);
        double time2 = SortHelper.test(BubbleSort2::sort, arr2);
        System.out.println(time1 + "s");
        System.out.println(time2 + "s");
    }
}
