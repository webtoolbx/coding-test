package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ValidParentheses {

    @Test
    void validParentheses() {
        validParentheses("{()}");
    }

    public boolean validParentheses(String s) {
        Stack<Character> stack = new Stack();
        // 시간 복잡도 O(n) 공간복잡도 O(n)
        for(char c : s.toCharArray()){
            switch(c){
                case '(','[','{' -> stack.push(c);
                case ')' -> {
                    if(stack.isEmpty()){
                        return false;
                    } else if(stack.peek() != '('){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
                case '}' -> {
                    if(stack.isEmpty()){
                        return false;
                    } else if(stack.peek() != '{'){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
                case ']' -> {
                    if(stack.isEmpty()){
                        return false;
                    } else if(stack.peek() != '['){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
