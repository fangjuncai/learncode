package com.learn.java.javabase.leecode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-22 16:36
 **/

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 */
public class LeastKNumbers {

    public static void main(String[] args) {
        testNumQuickSort();
    }

    /*
    执行用时：9 ms, 在所有 Java 提交中击败了49.46%的用户
    内存消耗：39.8 MB, 在所有 Java 提交中击败了58.24%的用户
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        quickSork(arr, 0, arr.length - 1);
        int[] aux = new int[k];
        aux = Arrays.copyOf(arr, k);
        return aux;
    }

    /*
执行用时：26 ms, 在所有 Java 提交中击败了12.70%的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了63.86%的用户
可以方便的节约内存
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        if (k == 0) {
            return new int[0];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                integerPriorityQueue.add(arr[i]);
            } else {
                if (integerPriorityQueue.peek() > arr[i]) {
                    integerPriorityQueue.poll();
                    integerPriorityQueue.add(arr[i]);
                }
            }

        }
        int[] aux = new int[k];
        for (int i = 0; i < k; i++) {
            aux[i] = integerPriorityQueue.poll();
        }
        return aux;
    }

    /**
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbersByArrays(int[] arr, int k) {
        Arrays.sort(arr);
        int[] aux = new int[k];
        aux = Arrays.copyOf(arr, k);
        return aux;
    }

    //快排
    public static void quickNumsSork(int[] nums, int leftIndex, int rightIndex, int k) {
        if (leftIndex < rightIndex) {
            int flagIndex = numpartion2(nums, leftIndex, rightIndex, k);
            if (flagIndex >= k) {
                return;
            }
            quickNumsSork(nums, leftIndex, flagIndex, k);
            quickNumsSork(nums, flagIndex + 1, rightIndex, k);
        }
    }

    public static int numpartion2(int[] nums, int index, int leftIndex, int rightIndex) {
        int flag = nums[leftIndex];
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && nums[rightIndex] >= flag) {
                rightIndex--;
            }
            nums[leftIndex] = nums[rightIndex];
            //相等的元素 可能会放到右边 因此是不稳定的
            while (leftIndex < rightIndex && nums[leftIndex] <= flag) {
                leftIndex++;
            }
            nums[rightIndex] = nums[leftIndex];
        }
        nums[leftIndex] = flag;
        return leftIndex;

    }

    //快排
    public static void quickSork(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int flagIndex = partion2(nums, leftIndex, rightIndex);
            quickSork(nums, leftIndex, flagIndex);
            quickSork(nums, flagIndex + 1, rightIndex);
        }
    }

    public static int partion2(int[] nums, int leftIndex, int rightIndex) {
        int flag = nums[leftIndex];
        while (leftIndex < rightIndex) {

            while (leftIndex < rightIndex && nums[rightIndex] >= flag) {
                rightIndex--;
            }
            nums[leftIndex] = nums[rightIndex];
            //相等的元素 可能会放到右边 因此是不稳定的
            while (leftIndex < rightIndex && nums[leftIndex] <= flag) {
                leftIndex++;
            }
            nums[rightIndex] = nums[leftIndex];
        }
        nums[leftIndex] = flag;
        return leftIndex;

    }

    private static void testQuickSort() {
        int[] nums = new int[]{10, 101, 102, 3, 4, 10, 9, 11, 100, 7, 99, 0, 20};
        quickSork(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(item -> System.out.println(item));
    }

    private static void testNumQuickSort() {
        //[0,0,0,2,0,5]
        int[] nums = new int[]{0, 0, 0, 2, 0, 5};
        int[] aux = getLeastNumbers2(nums, 1);
        Arrays.stream(aux).forEach(item -> System.out.println(item));
    }
}
