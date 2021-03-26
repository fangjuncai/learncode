package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-07 16:57
 **/
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindromeForce("ac"));
    }

    //执行用时：256 ms, 在所有 Java 提交中击败了39.77%的用户内存消耗：38.3 MB, 在所有 Java 提交中击败了94的用户
    public String longestPalindromeForce(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        //最小值肯定是1
        int maxIndex = 1;
        int begin = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int m = i + 1; m < chars.length; m++) {
                if (m - i + 1 > maxIndex && isValidPal(chars, i, m)) {
                    maxIndex = m - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxIndex);
    }

    // 执行用时：172 ms, 在所有 Java 提交中击败了55.76%的用户
    //内存消耗：42.7 MB, 在所有 Java 提交中击败了34.78%的用户
    public String longestPalindromeDynamic(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        for (int j = 1; j < len; j++) {
            for (int m = 0; m < j; m++) {
                if (chars[j] != chars[m]) {
                    dp[m][j] = false;
                } else {
                    if (j - m < 3) {
                        dp[m][j] = true;
                    } else {
                        dp[m][j] = dp[m + 1][j - 1];
                    }
                }
                if (dp[m][j] && j - m + 1 > maxLen) {
                    maxLen = j - m + 1;
                    begin = m;
                }
            }
        }

        return s.substring(begin, maxLen + begin);
    }

    private boolean isValidPal(char[] chars, int i, int m) {
        int left = i;
        int right = m;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            if (chars[left] == chars[right]) {
                left++;
                right--;
            }

        }
        return true;
    }
}
