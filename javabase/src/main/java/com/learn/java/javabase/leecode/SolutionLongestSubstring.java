package com.learn.java.javabase.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author: fangjc
 * @create: 2021-02-25 19:16
 **/
public class SolutionLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new SolutionLongestSubstring().lengthOfLongestSubstring("abcabccccdefg"));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {

            if (charMap.containsKey(s.charAt(i))) {
                //left = Math.max(left,i);
                left = Math.max(left, charMap.get(s.charAt(i)) + 1);
            }
            charMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
    /*
    3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0


提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
通过次数841,757提交次数2,307,880
在真实的面试中遇到过这道题？
     */
}
