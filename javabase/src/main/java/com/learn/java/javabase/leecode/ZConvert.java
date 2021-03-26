package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-13 23:25
 **/
public class ZConvert {
    public static void main(String[] args) {
        //System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("AA", 1));
    }
    //执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
    //内存消耗：38.5 MB, 在所有 Java 提交中击败了93.84%的用户

    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (numRows == 1) {
            return s;
        }
        char[] res = new char[len];
        int k = 0;
        int cycle = 2 * numRows - 2;
        for (int m = 0; m < numRows; m++) {
            //约束cycle>0 否则跳出循环
            for (int n = 0; n + m < len; n = n + cycle) {
                //从n+m开始
                //同行竖线的位置
                res[k] = chars[n + m];
                k++;
                //
                /*加上同行折线的位置，约束下标的上线不能超过最后的位置，比如最后没有斜线了，到了I这个位置之后就没有斜线了
                P   A   H
                A P L S I
                Y   I   R
                 */
                if (m != 0 && m != numRows - 1 && n + cycle - m < len) {
                    int index = n + cycle - m;
                    res[k] = chars[index];
                    k++;
                }
            }
        }
        return String.valueOf(res);


    }
}
