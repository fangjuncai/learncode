package com.learn.java.javabase.alogrithm;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-07 13:06
 **/
public class KMPUtil {
    public static void main(String[] args) {
//        System.out.println(KMPUtil.strStrForce("mississippi", "issip"));
//        System.out.println(KMPUtil.strStrForce("aaaaa", "bba"));
        System.out.println(kmp("mississippi", "issip"));
    }

    public static int kmp(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty()) {
            return -1;
        }
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int sLen = s.length;
        int pLen = p.length;
        int k = 0;
        int i = 0;
        int[] next = getNext(needle);
        for (i = 0; i < sLen && k < pLen; ) {
            //k可能会为-1 k右移动i-next[k]
            if (k == -1 || s[i] == p[k]) {
                i++;
                k++;
            } else {
                //不在回退i 只确定k
                //i = i - k + 1;
                k = next[k];
                //break;
            }


        }
        if (k == pLen) {
            return i - k;
        } else {
            return -1;
        }

    }

    private static int[] getNext(String needle) {
        char[] p = needle.toCharArray();
        int k = -1;
        int[] next = new int[needle.length()];
        int j = 0;
        next[0] = -1;

        while (j < needle.length() - 1) {
            if (k == -1 || p[k] == p[j]) {
                //自加j
                //执行用时：3 ms, 在所有 Java 提交中击败了37.84%的用户内存消耗：38.6 MB, 在所有 Java 提交中击败了16.85%
                // 的用户

                if (p[++j] == p[++k]) {
                    next[j] = next[k];
                } else {
                    //j之后不相等
                    next[j] = k;
                }
                //执行用时：3 ms, 在所有 Java 提交中击败了 37.84% 的用户 内存消耗：38.7 MB, 在所有 Java 提交中击败了 8.95% -30的用户
                //k之前已经有了p[k-1]=p[j-1] 即next[k]=next[j];
                // p[++j]==p[++k]
                //next[++j] = ++k;
            } else {
                //递归前缀后缀索引 next[j]表示表示j之前相同的前缀后缀长度
                k = next[k];
            }
        }
        return next;

    }
    /*
    行用时：1 ms, 在所有 Java 提交中击败了71.41%的用户
    内存消耗：38.9 MB, 在所有 Java 提交中击败了5.11%-37的用户
     */

    public static int strStrForce(String haystack, String needle) {
//        if (null == haystack || haystack.isEmpty() || null == needle || needle.isEmpty()) {
//            return -1;
//        }
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int sLen = s.length;
        int pLen = p.length;
        int k = 0;
        int i = 0;
        for (i = 0; i < sLen && k < pLen; ) {
            if (s[i] == p[k]) {
                i++;
                k++;
            } else {
                //回退+1
                i = i - k + 1;
                k = 0;
                //break;
            }


        }
        if (k == pLen) {
            return i - k;
        } else {
            return -1;
        }
    }
}
