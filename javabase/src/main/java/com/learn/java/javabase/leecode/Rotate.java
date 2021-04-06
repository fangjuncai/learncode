package com.learn.java.javabase.leecode;

import org.apache.commons.lang3.StringUtils;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-01 17:03
 **/
public class Rotate {
    public static void main(String[] args) {
        System.out.println(StringUtils.lowerCase("A cccc "));
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[i][j] = matrix[n - 1 - j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=matrix_new[i][j];
            }
        }
    }
}
