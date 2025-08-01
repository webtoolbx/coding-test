package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class Q3069_DistributeElements {

    @Test
    void test() {
        System.out.println(Arrays.toString(resultArray(new int[] {2, 1, 3})));
        System.out.println(Arrays.toString(resultArray(new int[] {5, 4, 3, 8})));
    }

    public int[] resultArray(int[] nums) {
        Stack<Integer> s1 =  new Stack<>();
        Stack<Integer> s2 =  new Stack<>();

        s1.push(nums[0]);
        s2.push(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (s1.peek() > s2.peek()) {
                s1.push(nums[i]);
            } else {
                s2.push(nums[i]);
            }
        }

        int[] answer = new int[nums.length];
        int idx = nums.length - 1;
        while(!s2.isEmpty()){
            answer[idx--] = s2.pop();
        }
        while(!s1.isEmpty()){
            answer[idx--] = s1.pop();
        }
        return answer;
    }
}
