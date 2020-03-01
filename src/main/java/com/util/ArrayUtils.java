package com.util;

import java.util.Arrays;
import java.util.Random;

public final class ArrayUtils {

    private ArrayUtils() {}

    public static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static Integer[] generateRandomIntArr(int size, int min, int max) {
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = min + random.nextInt(max - min);
        }
        return arr;
    }

    /**
     * 生成一个近乎有序的数组
     * @param size          数组大小
     * @param swapTimes     交换次数
     */
    public static Integer[] generateNearlyOrderedIntArr(int size, int swapTimes) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int posx = random.nextInt(size);
            int posy = random.nextInt(size);
            swap(arr, posx, posy);
        }
        return arr;
    }

    public static <E> E[] copy(E[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }
}
