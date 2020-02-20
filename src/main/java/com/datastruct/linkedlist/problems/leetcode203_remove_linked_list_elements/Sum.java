package com.datastruct.linkedlist.problems.leetcode203_remove_linked_list_elements;

public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 对[l, arr.length)范围内的数组元素求和
    private static int sum(int[] arr, int l) {
        if (l == arr.length - 1) {
            return arr[l];
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(arr));
    }
}
