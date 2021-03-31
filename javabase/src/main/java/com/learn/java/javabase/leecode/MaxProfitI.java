package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-27 18:22
 **/
public class MaxProfitI {
    public static void main(String[] args) {
        System.out.println(new MaxProfitI().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int dayLen = prices.length;
        if (dayLen <= 1) {
            return 0;
        }
        //dp[][] 第n天卖最大的利润
        int[][] dp = new int[dayLen][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < dayLen; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //只会买一次 隐藏的条件
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[dayLen - 1][0];
    }
}
