package com.leetcode;

/**
 * @author 拓破
 */
class Solution283 {
    // 把nums数组中的所有0移动到数组末尾
    // 1. 保持非零元素的相对顺序
    // 2. 原地完成，不使用额外的空间
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        // 两个指针
        // k指针用于放置下一个非零元素，i指针用于遍历
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
