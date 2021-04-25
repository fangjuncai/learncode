package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-03 22:17
 **/
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(9));
    }
    public int hammingWeight(int n) {
        int res = 0;
        int num = n;
        //会无限循环  num==0要跳出来
        while (num >= 0) {
            res += num & 1;
            num = num >>> 1;
        }
        return res;

    }
}
/**
 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

 示例 1：

 输入：00000000000000000000000000001011
 输出：3
 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */