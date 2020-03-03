package com.algo.search;

import com.util.ArrayUtils;

// 二分查找法
public class BinarySearch {

    public static int search(Comparable[] arr, Comparable target) {

        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target.compareTo(arr[mid]) == 0) {
                return mid;
            } else if (target.compareTo(arr[mid]) < 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Integer[] arr = ArrayUtils.generateRandomIntArr(100, 0, 101);
        int index = BinarySearch.search(arr, 50);
        System.out.println("index of 50 is: " + index);
    }
}
