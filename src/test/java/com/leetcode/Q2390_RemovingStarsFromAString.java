package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Q2390_RemovingStarsFromAString {

    @Test
    void test() {
        System.out.println("result : " + removeStars("leet**cod*e"));
        System.out.println("result : " + removeStarsNotUsingStack("leet**cod*e"));
        System.out.println("result : " + removeStarsIndex("leet**cod*e"));
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

    public String removeStarsNotUsingStack(String s){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(char c : s.toCharArray()){
            if(c == '*'){
                if(idx > 0){
                    idx--;
                    sb.deleteCharAt(idx);
                }
            } else {
                idx++;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeStarsIndex(String s){
        char[] arr = s.toCharArray();
        int index = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '*'){
                if(index > 0){
                    index--;
                }
            } else {
                arr[index] = arr[i];
                index++;
            }
        }

        return new String(arr, 0, index);
    }
}
