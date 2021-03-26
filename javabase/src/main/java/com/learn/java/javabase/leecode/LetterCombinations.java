package com.learn.java.javabase.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-21 22:04
 **/
public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
    //执行用时：1 ms, 在所有 Java 提交中击败了83.41%的用户 内存消耗：37.1 MB, 在所有 Java 提交中击败了80.51%的用户
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;

        }
        Map<Character, String> lettersMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        int index = 0;
        backtrack(digits, lettersMap, index, new StringBuffer(), res);
        return res;
    }

    private void backtrack(String digits, Map<Character, String> lettersMap, int index, StringBuffer stringBuffer, List<String> res) {
        if (index == digits.length()) {
            res.add(stringBuffer.toString());
            return;
        } else {
            Character character = digits.charAt(index);
            String letters = lettersMap.get(character);
            for (int i = 0; i < letters.length(); i++) {
                stringBuffer.append(letters.charAt(i));
                backtrack(digits, lettersMap, index + 1, stringBuffer, res);
                //只保留index+1
                stringBuffer.deleteCharAt(index);

            }
        }
    }
}
