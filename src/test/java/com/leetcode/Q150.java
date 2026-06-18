package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q150 {

    @Test
    void test() {
        assertThat(evalRPN(new String[]{"2","1","+","3","*"})).isEqualTo(9);
        assertThat(evalRPN(new String[]{"4","13","5","/","+"})).isEqualTo(6);
        assertThat(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})).isEqualTo(22);
    }

    public int evalRPN(String[] tokens) {
        // 무조건 스택이네
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(String t : tokens){
            switch(t){
                case "+" -> {
                    int d2 = stack.pop();
                    int d1 = stack.pop();
                    stack.push(d2 + d1);
                }
                case "-" -> {
                    int d2 = stack.pop();
                    int d1 = stack.pop();
                    stack.push(d1 - d2);
                }
                case "*" -> {
                    int d2 = stack.pop();
                    int d1 = stack.pop();
                    stack.push(d1 * d2);
                }
                case "/" -> {
                    int d2 = stack.pop();
                    int d1 = stack.pop();
                    stack.push(d1 / d2);
                }
                default -> {
                    stack.push(Integer.valueOf(t));
                }
            }
        }
        return stack.pop();
    }
}
