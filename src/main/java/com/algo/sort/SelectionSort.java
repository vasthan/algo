package com.algo.sort;

import com.adc.Student;
import com.util.ArrayUtils;

import java.util.Arrays;

public class SelectionSort {

    private SelectionSort() {}

    public static void sort(Comparable[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 寻找[i, arr.length)区间里最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            ArrayUtils.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayUtils.generateRandomIntArr(10, 0, 100);
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        String[] arr2 = {"b", "c", "g", "a", "z"};
        SelectionSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        Student[] students = new Student[3];
        students[0] = new Student("Bob", 99);
        students[1] = new Student("Alice", 100);
        students[2] = new Student("Yong", 98);
        SelectionSort.sort(students);
        System.out.println(Arrays.toString(students));


        Integer[] arr3 = ArrayUtils.generateRandomIntArr(100000, 0, Integer.MAX_VALUE);
        double time = SortHelper.test(SelectionSort::sort, arr3);
        System.out.println("cost time: " + time + "s");
    }
}
