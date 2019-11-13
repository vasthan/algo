package com.adc.sort;

import java.util.Random;

public class SortHelper {

    public static int[] generateIntArray(int size, int maxValue) {

        Random random = new Random();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(maxValue);
        }
        return arr;
    }
}
