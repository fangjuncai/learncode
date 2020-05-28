package com.learn.java.javabase.alogrithm;

import java.util.Arrays;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * 空间复杂度(Space Complexity)是对一个算法在运行过程中临时占用存储空间大小的量度
 * 在计算机科学中，时间复杂性，又称时间复杂度，算法的时间复杂度是一个函数，它定性描述该算法的运行时间。
 * 堆排序、快速排序、希尔排序、直接选择排序是不稳定的排序算法，而基数排序、冒泡排序、直接插入排序、折半插入排序、归并排序是稳定的排序算法。
 * @create: 2020-05-16 16:43
 **/
public class SortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 3, 4, 10, 9, 11, 100, 7, 99, 0, 20};
        //ownSort(nums);
        //bubbleSort(nums);
        //insertSort(nums);
        quickSork(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(item -> System.out.println(item));
    }

    //算一种选择排序  每次都是最小放在首位；也可以实现最大值放到最后，内循环递减
    public static void ownSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int m = i + 1; m < nums.length; m++) {
/*                if(nums[i] > nums[m])
                {

                    swap(i,m,nums);//交换次数多了
                }*/


                if (nums[minIndex] > nums[m]) {
                    minIndex = m;
                }
            }
            //相同元素没有交换 所以是稳定的排序算法
            swap(i, minIndex, nums);
        }
        System.out.println("-----------------");
        Arrays.stream(nums).forEach(item -> System.out.println(item));
        System.out.println("-----------------");


    }

    //冒泡 内循环相邻元素两两相比 交换  把最大的放在最后
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int m = 0; m < nums.length - i - 1; m++) {
                if (nums[m] > nums[m + 1]) {
                    swap(m, m + 1, nums);
                }
            }
        }
    }

    //快排
    public static void quickSork(int[] nums, int left, int right) {
        if (left < right) {
            int flag = partion2(nums, left, right);
            quickSork(nums, left, flag - 1);
            quickSork(nums, flag + 1, right);
        }


    }

    public static int partion(int[] nums, int left, int right) {

        int flag = left;
        int tmp = nums[flag];
        int index = left + 1;
        //index最后用来放置tmp
        for (int i = index; i <= right; i++) {
            if (nums[i] < tmp) {
                //交换的 小于tmp 大于tmp的值
                swap(i, index, nums);
                //left 右移一位  找到比tmp小，才放入index的位置，而index位置的值放入小于的值的位置
                index++;
            }
        }
        //index -1才是left应该放的位置
        swap(left, index - 1, nums);
        //返回位置
        return index - 1;
    }

    public static int partion2(int[] nums, int left, int right) {
        int base = nums[left];
        while (left < right) {
            //left < right 否则一直循环下去,相同的元素也需要处理，如果都不处理相等，就会一直跳出，循环一直
            while (left < right && nums[right] >= base) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= base) {
                left++;
            }
            nums[right] = nums[left];
            //System.out.println(left+" left = "+nums[left]);
            //System.out.println(right+" right = "+nums[right] );
        }
        nums[left] = base;
        return left;
    }
    //归并排序

    //希尔排序

    //插入排序  10 9 11 1
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int m = 0;
            //m<i
            //从i个有序的数从后向前比较 比将要的插入值大 向后移动
            //插入的值是最小的 m--最后是-1
            //实际插入是在最后比较的值的后一位,也可以理解为找到了比插入值小的位置m，放在它的后面m+1
            //没有因为相同的值发生顺序的变化 也是有序的
            for (m = i - 1; m >= 0 && nums[m] > tmp; m--) {
                nums[m + 1] = nums[m];
            }
            //System.out.println("m " + m);
            nums[m + 1] = tmp;
        }
    }

    //直接交换没有用的
    public static void swap(int m, int n) {
        System.out.println("m=" + m + " n= " + n);
        int tmp;
        tmp = m;
        m = n;
        n = tmp;
        System.out.println(" after m=" + m + " n= " + n);

    }

    public static void swap(int m, int n, int nums[]) {
//        System.out.println("m="+m+" n= "+n);
        int tmp;
        tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
//        System.out.println(" after m="+m+" n= "+n);

    }
}
