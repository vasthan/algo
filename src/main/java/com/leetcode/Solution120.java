package com.leetcode;

import java.util.List;

/**
 * @author 拓破
 */
public class Solution120 {

    /*
     2
     3 4
     6 5 7
     4 1 8 3
        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        // arr[i][j]存放从(0, 0)到(i, j)的最小路径和
        int[][] arr = new int[m][m];
        arr[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][0] + triangle.get(i).get(j);
                } else if (j == i) {
                    arr[i][j] = arr[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    arr[i][j] = Math.min(arr[i - 1][j], arr[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int sum : arr[m - 1]) {
            res = Math.min(res, sum);
        }
        return res;
    }
}
