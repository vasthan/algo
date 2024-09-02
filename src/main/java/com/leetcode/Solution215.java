package com.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 */
public class Solution215 {

    // 解法一：优先队列，维护一个k个元素的最小堆，时间复杂度nlogk
    public int findKthLargest(int[] nums, int k) {
        // Java的PriorityQuery默认为最小堆，堆顶元素最小
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (num > heap.peek()) {
                heap.remove();
                heap.add(num);
            }
        }
        return heap.peek();
    }

    // 解法二：快速排序partition
    public int findKthLargest2(int[] nums, int k) {
        // 第k大元素，在排序好的数组中的索引为nums.length - k
        int indexK = nums.length - k;
        int l = 0, r = nums.length - 1;
        while (true) {
            int p = partition(nums, l, r);
            if (p == indexK) {
                break;
            } else if (p < indexK) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return nums[indexK];
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];

        int i = l + 1, j = r;
        while (i <= j) {
            while (i <= j && nums[i] < v) {
                i++;
            }
            while (i <= j && nums[j] > v) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }
}
