package com.leetcode;

import java.util.ArrayDeque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q151_ReverseWordsinaString {

    @Test
    void testReverseWords() {
        Q151_ReverseWordsinaString solution = new Q151_ReverseWordsinaString();

        // Test case 1
        String s1 = "the sky is blue";
        String expected1 = "blue is sky the";
        Assertions.assertEquals(expected1, solution.reverseWords(s1));

        // Test case 2
        String s2 = "  hello world  ";
        String expected2 = "world hello";
        Assertions.assertEquals(expected2, solution.reverseWords(s2));

        // Test case 3
        String s3 = "a good   example";
        String expected3 = "example good a";
        Assertions.assertEquals(expected3, solution.reverseWords(s3));

        // Test case 4: Empty string
        String s4 = "";
        String expected4 = "";
        Assertions.assertEquals(expected4, solution.reverseWords(s4));

        // Test case 5: String with only spaces
        String s5 = "   ";
        String expected5 = "";
        Assertions.assertEquals(expected5, solution.reverseWords(s5));

        // Test case 6: Single word
        String s6 = "word";
        String expected6 = "word";
        Assertions.assertEquals(expected6, solution.reverseWords(s6));
    }

    public String reverseWords(String s) {
        // 단어를 역순으로 리턴
        // ArrayDeque에 넣고 역순으로 뽑기 (Stack 처럼 사용)
        // 단어를 넣는건 StringBuilder에 추가하고 Space바나 마지막에 도달하면 집어 넣는다.

        // 공간 O(n)
        // 시간 O(n)
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        int length = s.length();
        for(int i = 0; i < length; i++){
            if(s.charAt(i) == ' '){
                if(!word.isEmpty()){
                    stack.push(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(s.charAt(i));
            }
        }
        if(!word.isEmpty()){
            stack.push(word.toString());
            word.setLength(0);
        }
        return String.join(" ", stack);
    }
}
