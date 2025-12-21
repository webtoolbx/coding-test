package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Quest2_EvaluateReversePolishNotation {

    @Test
    void test() {
        System.out.println("result : " + evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    // Stack
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = Set.of("+", "-", "*", "/");
        for(String token : tokens){
            if(!set.contains(token)){
                stack.push(Integer.valueOf(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if("+".equals(token)){
                    stack.push(num1 + num2);
                } else if("-".equals(token)){
                    stack.push(num2 - num1);
                } else if("*".equals(token)){
                    stack.push(num2 * num1);
                } else if("/".equals(token)){
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }
}
