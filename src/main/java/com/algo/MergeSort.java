package com.algo;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);

            // 优化，左右两边已经有序，就不用merge了
            if (nums[m] > nums[m + 1]) {
                merge(nums, l, m, r);
            }
        }
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] arr = new int[r + 1];
        System.arraycopy(nums, l, arr, l, r - l + 1);

        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m)
                nums[k] = arr[j++];
            else if (j > r)
                nums[k] = arr[i++];
            else
                nums[k] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        MergeSort merge = new MergeSort();
        merge.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
