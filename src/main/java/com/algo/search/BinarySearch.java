package com.algo.search;

// 二分搜索
public class BinarySearch {

    // 查找某个值
    public static int search(Comparable[] arr, Comparable target) {

        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target.compareTo(arr[mid]) == 0) {
                return mid;
            } else if (target.compareTo(arr[mid]) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // TODO 查找大于等于target的最小值
    public static int floor(Comparable[] arr, Comparable target) {
        return -1;
    }

    // TODO 查找小于等于target的最大值
    public static int ceil(Comparable[] arr, Comparable target) {
        return -1;
    }
}
