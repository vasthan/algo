package com.leetcode;

class Solution75 {

    // 通用解法：计数排序，先扫描一遍，记录每个元素出现的次数，再按顺序放入数组中
    // 该问题的优化解法，利用三路快排的partition
    public void sortColors(int[] nums) {

        // 定义3个区间段
        // [0, l] 区间的元素为0
        // [l + 1， i）区间元素为1
        // [r, n - 1] 区间元素为2
        int l = -1, r = nums.length;
        for (int i = 0; i < r;) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                l++;
                swap(nums, l, i);
                i++;
            } else {
                r--;
                swap(nums, i, r);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
