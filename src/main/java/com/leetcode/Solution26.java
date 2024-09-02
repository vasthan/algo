package com.leetcode;

import java.util.Arrays;

class Solution26 {
    // 删除有序数组中的重复元素，每个元素只保留一个，返回唯一元素的个数
    // 1. 原地删除 2. 元素的相对顺序保持不变
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = {1,1,2,3,4,5,5,6};
        System.out.println(solution26.removeDuplicates(nums) + ", " + Arrays.toString(nums));
    }
}
