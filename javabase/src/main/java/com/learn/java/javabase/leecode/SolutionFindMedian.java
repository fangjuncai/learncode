package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-02-25 23:36
 **/
public class SolutionFindMedian {
    public static void main(String[] args) {
        int []nums1 = new int[]{1,2};
        int []nums2= new int[]{3,4};
        System.out.println(new SolutionFindMedian().findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int[] tmp = new int[nums1Len + nums2Len];
        int num1LeftIndex = 0;
        int num2LeftIndex = 0;
        int index = 0;
        while (num1LeftIndex < nums1Len && num2LeftIndex < nums2Len) {
            if (nums1[num1LeftIndex] < nums2[num2LeftIndex]) {
                tmp[index] = nums1[num1LeftIndex];
                num1LeftIndex++;
                index++;
            }
           else if(nums1[num1LeftIndex] >= nums2[num2LeftIndex]){
                tmp[index] = nums2[num2LeftIndex];
                num2LeftIndex++;
                index++;
            }

        }
        while (num1LeftIndex<nums1Len){
            tmp[index]=nums1[num1LeftIndex];
            num1LeftIndex++;
            index++;
        }
        while (num2LeftIndex<nums2Len)
        {
            tmp[index]=nums2[num2LeftIndex];
            num2LeftIndex++;
            index++;
        }
        double res = 0;
        if((nums1Len + nums2Len)%2==0){
            int mid = (nums1Len + nums2Len)/2;

            res =(tmp[mid]+tmp[mid-1])/(2*1.0);
        }else {
            res= tmp[(nums1Len + nums2Len)/2];
        }
        return res;

    }
}
/*

示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：

输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
示例 4：

输入：nums1 = [], nums2 = [1]
输出：1.00000
示例 5：

输入：nums1 = [2], nums2 = []
输出：2.00000
 

提示：

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

执行用时：
3 ms
, 在所有 Java 提交中击败了
82.40%
的用户
内存消耗：
39.6 MB
, 在所有 Java 提交中击败了
84.90%
的用户
 */