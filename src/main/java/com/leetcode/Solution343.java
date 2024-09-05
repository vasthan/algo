package com.leetcode;

import java.util.Arrays;

/**
 * @author 拓破
 */
public class Solution343 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution343().integerBreak(2));
        System.out.println(new Solution343().integerBreak(60));
    }
}
