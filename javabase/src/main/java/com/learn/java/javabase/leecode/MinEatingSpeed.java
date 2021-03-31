package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-26 22:53
 **/
public class MinEatingSpeed {
    public static void main(String[] args) {
        int[] piles = new int[]{3, 6, 7, 11};
        System.out.println(new MinEatingSpeed().minEatingSpeed(piles, 8));
        //System.out.println(Math.ceil(11 * 1.0 / 6));  //2
        //System.out.println(Math.ceil(11  / 6));  //1
    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for (int a : piles) {
            max = Math.max(max, a);
        }

        int left = 1;
        int right = max;
        int middle;

        while (left < right) {
            middle = (left + right) >> 1;
            if (!possible(piles, middle, h)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private boolean possible(int[] piles, int middle, int h) {
        int sum = 0;
        for (int pile : piles) {
            //sum = sum + (int) Math.ceil(pile * 1.0 / middle);
            //sum = sum + (pile + middle - 1) / middle;
            sum = sum + (pile - 1) / middle+1;
        }
        return sum <= h;
    }
}
