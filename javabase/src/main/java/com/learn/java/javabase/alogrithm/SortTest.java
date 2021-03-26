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

    //算一种选择排序  每次都是最小放在首位；也可以实现最大值放到最后，内循环递减
    public static void swapSort(int[] nums) {
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
            //相同元素没有交换 所以是稳定的排序算法 只交换一次
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
        }
        nums[left] = base;
        return left;
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


    //归并排序

    //希尔排序


    //直接交换没有用的
    public static void swap(int m, int n) {
        System.out.println("m=" + m + " n= " + n);
        int tmp;
        tmp = m;
        m = n;
        n = tmp;
        System.out.println(" after m=" + m + " n= " + n);

    }

    //容器交换
    public static void swap(int m, int n, int nums[]) {
//        System.out.println("m="+m+" n= "+n);
        int tmp;
        tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
//        System.out.println(" after m="+m+" n= "+n);

    }

    public static void mergeSort(int[] nums, int lowIndex, int highIndex) {

        if (lowIndex < highIndex) {
            int[] temp = new int[highIndex - lowIndex + 1];

            int middle = (lowIndex + highIndex) / 2;
            //左分
            mergeSort(nums, lowIndex, middle);
            //右分
            mergeSort(nums, middle + 1, highIndex);
            //merge
            merge(nums, lowIndex, middle, highIndex, temp);
        }

    }

    private static void merge(int[] nums, int lowIndex, int middleIndex, int highIndex, int[] temp) {
        int leftBegin = lowIndex;
        int rightBegin = middleIndex + 1;
        int i = 0;
        while (leftBegin <= middleIndex && rightBegin <= highIndex) {
            if (nums[leftBegin] < nums[rightBegin]) {
                temp[i] = nums[leftBegin];
                leftBegin++;
            } else {
                temp[i] = nums[rightBegin];
                rightBegin++;
            }
            i++;

        }

        while (leftBegin <= middleIndex) {
            temp[i] = nums[leftBegin];
            i++;
            leftBegin++;

        }
        while (rightBegin <= highIndex) {
            temp[i] = nums[rightBegin];
            i++;
            rightBegin++;
        }
        int m = 0;
        for (int j = lowIndex; j <= highIndex && m <= i; j++) {
            nums[j] = temp[m];
            m++;
        }

    }

    //插入排序  10 9 11 1  移动法
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

    //插入排序  10 9 11 1  移动法
    public static void insertSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int m = 0;
/*            for (m = i - 1; m >= 0 && nums[m] > tmp; m--) {
                nums[m + 1] = nums[m];
            }*/
            for (m = i - 1; m >= 0; m--) {
                if (nums[m] > tmp) {
                    nums[m + 1] = nums[m];
                }
            }
            nums[m + 1] = tmp;
        }
    }

    public static void shellSort2(int[] arr) {
        //gap 长度的二分之一到1 循环1 组数=gap数 循环的次数
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int gapIndex = 0; gapIndex < gap; gapIndex++) {
                //插入排序的逻辑
                for (int i = gapIndex + gap; i < arr.length; i = i + gap) {
                    int tmp = arr[i];
                    int m;
                    //从0开始
                    for (m = i - gap; m >= 0 && arr[m] > tmp; m = m - gap) {
                        arr[m + gap] = arr[m];
                    }
                    //tmp最后插入到m的后面
                    arr[m + gap] = tmp;
                }
            }
        }
    }

    public static void shellSort(int[] arr) {
        //gap 长度的二分之一到1 循环1 组数=gap数 循环的次数
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int gapIndex = 0; gapIndex < gap; gapIndex++) {
                //插入排序的逻辑
                for (int i = gapIndex + gap; i < arr.length; i = i + gap) {
                    int tmp = arr[i];
                    if (arr[i] < arr[i - gap]) {
                        while ((i - gap) > 0 && tmp < arr[i - gap]) {
                            //元素
                            arr[i] = arr[i - gap];
                            i = i - gap;
                        }
                    }
                    arr[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 3, 4, 12, 9, 11, 100, 7, 99, 101, 21, 0};
        //ownSort(nums);
        //bubbleSort(nums);
        //insertSort(nums);
        //quickSork(nums, 0, nums.length - 1);
        System.out.println("nums.length" + nums.length);
        //mergeSort(nums, 0, nums.length - 1);
        shellSort2(nums);
        Arrays.stream(nums).forEach(item -> System.out.println(item));
        System.out.println("nums.length" + nums.length);
    }

}
