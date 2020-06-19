package com.algo;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private Random rand = new Random();

    public void sort(int[] nums) {
        // quickSort1Way(nums, 0, nums.length - 1);
        // quickSort2Way(nums, 0, nums.length - 1);
        quickSort3Way(nums, 0, nums.length - 1);
    }

    // 一路快排
    private void quickSort1Way(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition1Way(nums, l, r);
            quickSort1Way(nums, l, p - 1);
            quickSort1Way(nums, p + 1, r);
        }
    }

    // 二路快排
    private void quickSort2Way(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition2Way(nums, l, r);
            quickSort2Way(nums, l, p - 1);
            quickSort2Way(nums, p + 1, r);
        }
    }

    // 三路快排，[l + 1, lt]区间存放小于基准点v的元素，[lt + 1, gt - 1]存放等于v的元素，[gt, r]存放大于v的元素
    // 三路分区快排适合对重复元素的数组进行排序
    private void quickSort3Way(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(nums, l, rand.nextInt(r - l + 1) + l);
        int v = nums[l];
        int lt = l, gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (nums[i] == v)
                i++;
            else if (nums[i] < v)
                swap(nums, i++, ++lt);
            else
                swap(nums, i, --gt);
        }
        quickSort3Way(nums, l, lt);
        quickSort3Way(nums, gt, r);
    }

    // 一趟遍历寻找分区位置，[l + 1, j]区间存小于v的元素，[j + 1, i)位置存大于v的元素，i是当前考察的位置
    private int partition1Way(int[] nums, int l, int r) {
        // TODO 随机选择基准点
        int v = nums[l];
        int j = l, i = j + 1;
        for (; i < nums.length; i++)
            if (nums[i] < v)
                swap(nums, ++j, i);
        swap(nums, l, j);
        return j;
    }

    // 对撞指针法寻找分区位置
    private int partition2Way(int[] nums, int l, int r) {
        // TODO 随机选择基准点
        int v = nums[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= v) j--;
            while (i < j && nums[i] <= v) i++;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        QuickSort quick = new QuickSort();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        quick.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
