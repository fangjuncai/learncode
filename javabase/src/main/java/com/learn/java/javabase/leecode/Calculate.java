package com.learn.java.javabase.leecode;

import java.util.Stack;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-31 14:56
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 整数除法仅保留整数部分。
 **/
public class Calculate {
    public static void main(String[] args) {
        System.out.println(new Calculate().calculate("3/2"));
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] chars = s.toCharArray();
        int len = chars.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (;i < len;) {
            char c = chars[i];
            if (c == '/' || c == '*' || c == '+' || c == '-') {
                i++;
            }
            int num = 0;
            //后面的元素
            while (i < len && Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
                i++;
            }

            switch (c) {
                case '+':
                    num = num;
                    break;
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = stack.pop() * num;
                    break;
                case '/':
                    num = stack.pop() / num;
                    break;


            }
            stack.push(num);
        }
        int sum = 0;
        for (int n : stack) {
            sum = sum + n;
        }

        return sum;


    }

    public int calculate2(String s) {
        s = s.replace(" ", "");
        char[] chars = s.trim().toCharArray();
        int charsLen = chars.length;
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < charsLen; ) {

            int num = 0;

            if (i < charsLen && Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
                i++;
            }
            nums.push(num);
            if (chars[i] == '/' || chars[i] == '*' || chars[i] == '+' || chars[i] == '-') {
                char tmp = chars[i];
                i++;
                while (chars[i] == ' ' && i < charsLen) {
                    i++;
                }
                num = chars[i] - '0';
                switch (tmp) {
                    case '+':
                        num = num;
                        break;
                    case '-':
                        num = -num;
                    case '*':
                        num = nums.pop() * num;
                        break;
                    case '/':
                        num = nums.pop() / num;
                        break;
                    default:
                        break;
                }
                nums.push(num);
            }


        }
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }


        return sum;
    }
}