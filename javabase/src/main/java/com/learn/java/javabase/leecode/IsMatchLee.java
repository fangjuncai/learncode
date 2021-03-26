package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc 正则表达式
 * @create: 2021-03-14 20:16
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 **/
public class IsMatchLee {


    public static void main(String[] args) {
        if (true) {

            System.out.println(new IsMatchLee().isMatch("aa", "a*"));
        }

    }


    public boolean isMatch(String s, String p) {
        int sourceLen = s.length();
        int patterLen = p.length();

        boolean[][] dp = new boolean[sourceLen + 1][patterLen + 1];
        dp[0][0] = true;//空串
        for (int i = 0; i <= sourceLen; i++) {
            for (int j = 1; j <= patterLen; j++) {
                if (p.charAt(j-1) == '*') {//j = 1开始自加 p[j] * p 的第 j 个字符是 *
                    //a*并没有匹配上
                    dp[i][j] = dp[i][j - 2];
                    // a*
                    if (match(s, p, i, j - 1)) {
                        /**
                         *  i-2 i-1 i     j-2 j-1 j
                         *    a  a|c a         a  *
                         *    dp[i][j - 2]是匹配单个a
                         *    多个a dp[i-1][j]
                         */
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    }

                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }


        return dp[sourceLen][patterLen];
    }


    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
