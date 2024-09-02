package com.leetcode;

/**
 * 合并两个有序数组
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = nums1.length - 1;
        while (k >= 0) {
            if (i < 0) {
                nums1[k] = nums2[j--];
            } else if (j < 0) {
                nums1[k] = nums1[i--];
            } else if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            k--;
        }
    }
}
