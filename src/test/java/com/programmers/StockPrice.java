package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.TreeMap;

public class StockPrice {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{4, 3, 1, 1, 0}, solution(new int[]{1, 2, 3, 2, 3}));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
            } else {
                while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                    // 떨어졌을 경우에는 비교해봐야지 idx 만 넣어도 비교 가능
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length -1 - idx;
        }

        return answer;
    }
}
