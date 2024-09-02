package com.leetcode;

import java.util.Arrays;

class Solution27 {
    // 给定数组nums，移除其中等于val的元素，返回剩余元素的数量（假设为k），要求这个k个元素放在nums数组的头部
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,4,6,7,8,4};
        Solution27 solution27 = new Solution27();
        System.out.println(solution27.removeElement(nums, 2) + ", " + Arrays.toString(nums));
        System.out.println(solution27.removeElement(nums, 4) + ", " + Arrays.toString(nums));
    }
}
