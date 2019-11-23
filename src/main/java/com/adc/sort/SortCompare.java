package com.adc.sort;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

    public static double time(String alg, Comparable[] arr) {
        Stopwatch timer = new Stopwatch();
        if ("Insertion".equals(alg)) {
            Insertion.sort(arr);
        }
        if ("Selection".equals(alg)) {
            Selection.sort(arr);
        }
        if ("Shell".equals(alg)) {
            Shell.sort(arr);
        }
        if ("Merge".equals(alg)) {
            Merge.sort(arr);
        }
        if ("Quick".equals(alg)) {
            Quick.sort(arr);
        }
        if ("Heap".equals(alg)) {
            Heap.sort(arr);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int n, int t) {
        double total = 0.0;
        Double[] arr = new Double[n];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                arr[j] = StdRandom.uniform();
            }
            total += time(alg, arr);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt(args[2]);
        int t = Integer.parseInt(args[3]);

        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);

        System.out.printf("%s 算法耗时：%f s\n", alg1, t1);
        System.out.printf("%s 算法耗时：%f s\n", alg2, t2);

    }
}
