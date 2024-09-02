package com.leetcode;

import java.util.Arrays;

class Solution80 {
    // 删除有序数组中的重复元素，相同元素最多保留2个，返回删除后数组的长度
    // 1. 原地删除
    // 最佳解法：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/solutions/702970/gong-shui-san-xie-guan-yu-shan-chu-you-x-glnq/
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        return removeDuplicates(nums, 2);
    }

    // 删除有序数组中的重复元素，相同元素最多保留n个
    private int removeDuplicates(int[] nums, int n) {
        int k = n;
        for (int i = n; i < nums.length; i++) {
            if (nums[i] != nums[k - n]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(solution80.removeDuplicates(nums) + ", " + Arrays.toString(nums));
    }
}
