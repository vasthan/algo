package com.algo;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            int j = i;
            // 插入排序可以提前终止内层循环
            for (; j > 0 && nums[j - 1] > v; j--)
                nums[j] = nums[j - 1];
            nums[j] = v;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        InsertionSort insert = new InsertionSort();
        insert.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
