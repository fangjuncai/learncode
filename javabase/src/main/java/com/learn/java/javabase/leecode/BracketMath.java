package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-08 10:27
 **/

import java.util.Scanner;
import java.util.Stack;

/**
 * @author David {[(三种括号匹配问题
 * {[()]} {}[]()匹配
 * {[}]不匹配
 */
public class BracketMath {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.next();

        BracketMath bracketMath = new BracketMath();

        if(bracketMath.fun(str)){
            System.out.println(str);
        }

    }

    public boolean fun(String str) {

        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '{':
                    stack.push("{");
                    break;

                case '[':
                    stack.push("[");
                    break;

                case '(':
                    stack.push("(");
                    break;

                case ')':
                    String str_little = stack.pop();
                    if (!str_little.equals("(")) {
                        return false;
                    }else{
                        break;
                    }

                case ']':
                    String str_middle = stack.pop();
                    if (!str_middle.equals("[")) {
                        return false;
                    }else{
                        break;
                    }

                case '}':
                    String str_large = stack.pop();
                    if (!str_large.equals("{")) {
                        return false;
                    }else{
                        break;
                    }

            }

        }
        if (stack.size() != 0) {
            return false;
        } else {
            return true;
        }
    }
}