package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Q2390_RemovingStarsFromAString {

    @Test
    void test() {
        System.out.println("result : " + removeStars("leet**cod*e"));
    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
