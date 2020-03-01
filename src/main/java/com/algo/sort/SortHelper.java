package com.algo.sort;

import java.util.function.Consumer;

public final class SortHelper {

    private SortHelper() {}

    public static double test(Consumer<Comparable[]> sortAlgo, Comparable[] arr) {
        long start = System.currentTimeMillis();
        sortAlgo.accept(arr);
        long end = System.currentTimeMillis();

        if (!isSorted(arr)) {
            throw new RuntimeException("alfo failed! arr is not sorted");
        }
        return (end - start) / 1000.0;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
