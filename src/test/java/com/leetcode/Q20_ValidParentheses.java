package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Q20_ValidParentheses {

    @Test
    void test() {
        Assertions.assertTrue(isValid("()"));
        Assertions.assertTrue(isValid("()[]{}"));
        Assertions.assertFalse(isValid("(]"));
        Assertions.assertFalse(isValid("([)]"));
        Assertions.assertTrue(isValid("{[]}"));
    }

    public boolean isValid(String s) {
        // Stack 처리
        Stack<Character> stack = new Stack<>();
        char[] open = new char[]{'(','{','['};
        char[] close = new char[]{')','}',']'};

        for(char c : s.toCharArray()){
            int n = -1;
            for(int i = 0; i < close.length; i++){
                if(c == close[i]){
                    n = i;
                    break;
                }
            }
            if(n != -1){
                if(stack.isEmpty()) return false;
                char o = stack.pop();
                if(open[n] != o){
                    return false;
                }
            } else {
                // open
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
