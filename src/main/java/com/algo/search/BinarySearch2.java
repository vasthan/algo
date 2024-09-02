package com.algo.search;

/**
 * @author 拓破
 */
public class BinarySearch2 {


    // 在有序数组nums中，寻找target，找到则返回target的索引，否则返回-1
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
