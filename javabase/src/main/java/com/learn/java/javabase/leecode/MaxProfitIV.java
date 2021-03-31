package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-27 17:31
 **/
public class MaxProfitIV {
    public static void main(String[] args) {
        System.out.println(new MaxProfitIV().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int k, int[] prices) {
        int dayLen = prices.length;
        if (dayLen <= 1) {
            return 0;
        }
        k = Math.min(k, dayLen / 2);
        //0 k次交易
        int[][][] dp = new int[dayLen][2][k + 1];
        for (int m = 0; m <= k; m++) {
            dp[0][0][m] = 0;
            dp[0][1][m] = -prices[0];
        }
        for (int i = 1; i <dayLen; i++) {

            for (int m = 1; m <= k; m++) {
                dp[i][0][m] = Math.max(dp[i - 1][0][m], dp[i - 1][1][m] + prices[i]);
                dp[i][1][m] = Math.max(dp[i - 1][1][m], dp[i - 1][0][m - 1] - prices[i]);
            }
        }

        return dp[dayLen - 1][0][k];
    }
}
