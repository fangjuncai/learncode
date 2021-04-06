package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-31 22:13
 **/
public class ModifyString {
    public static void main(String[] args) {
        System.out.println(new ModifyString().modifyString("?az"));
    }

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int charLen = chars.length;
        char prev;
        char behind;
        while (i < chars.length) {
            if (i == 0) {
                prev = ' ';
            } else {
                prev = chars[i - 1];
            }
            if (i == charLen - 1) {
                behind = ' ';
            } else {
                behind = chars[i + 1];
            }
            char temp = 'a';
            //找一个跟前后不一样的
            while (temp ==prev||temp==behind){
                temp++;
            }
            if(chars[i]=='?')
            chars[i]=temp;
            i++;
        }

        return String.valueOf(chars);
    }
}
