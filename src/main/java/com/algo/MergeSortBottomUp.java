package com.algo;

import java.util.Arrays;

public class MergeSortBottomUp {

    public void sort(int[] nums) {
        int n = nums.length;
        // 外层循环，每次归并的数组大小，1，2，4，8
        for (int sz = 1; sz < n; sz += sz) {
            // 内层循环，合并
            // sz = 1, [0]和[1]合并，[2]和[3]合并。。。
            // sz = 2，[0,1]和[2,3]合并，[4,5]和[6,7]合并
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对[i, i + sz - 1] 和 [i + sz, i + sz + sz - 1] 两部分进行合并
                // for循环中加入了i + sz < n条件，是为了保证右边的数组存在才能合并
                // 同样的，为了避免i + sz + sz - 1越界，右边的数组下标最多只能到n-1
                merge(nums, i, i + sz - 1, Math.min(n - 1, i + sz + sz - 1));
            }
        }
    }

    // 对[l, m] 和 [m + 1, r] 两部分进行归并
    private void merge(int[] nums, int l, int m, int r) {
        int[] tmp = new int[r + 1];
        System.arraycopy(nums, l, tmp, l, r - l + 1);

        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m)
                nums[k] = tmp[j++];
            else if (j > r)
                nums[k] = tmp[i++];
            else
                nums[k] = tmp[i] < tmp[j] ? tmp[i++] : tmp[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        MergeSortBottomUp merge = new MergeSortBottomUp();
        merge.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
