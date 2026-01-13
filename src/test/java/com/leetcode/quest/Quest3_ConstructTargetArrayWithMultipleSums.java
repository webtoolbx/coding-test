package com.leetcode.quest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Quest3_ConstructTargetArrayWithMultipleSums {

    @Test
    void test() {
        Assertions.assertTrue(isPossible(new int[]{9, 3, 5}));
        Assertions.assertFalse(isPossible(new int[]{1, 1, 1, 2}));
        Assertions.assertTrue(isPossible(new int[]{8, 5}));
        Assertions.assertTrue(isPossible(new int[]{1, 1000000}));

        Assertions.assertTrue(isPossible2(new int[]{9, 3, 5}));
        Assertions.assertFalse(isPossible2(new int[]{1, 1, 1, 2}));
        Assertions.assertTrue(isPossible2(new int[]{8, 5}));
        Assertions.assertTrue(isPossible2(new int[]{1, 1000000}));
    }

    public boolean isPossible(int[] target) {
        // 이걸 우선 순위 큐로 어떻게 푸냐
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);

        long totalSum = 0;
        for(int i : target){
            queue.offer(i);
            totalSum += i;
        }

        while(!queue.isEmpty()){
            int maxVal = queue.poll();
            long restSum = totalSum - maxVal;

            // 나머지 합이 1이면 가능
            if(maxVal == 1|| restSum == 1) return true;

            // 나머지 합이 최대값 미달이거나 0인 경우 불가
            if(restSum == 0 || maxVal <= restSum) return false;

            // 나머지 연산을 통해 이전 값 계산
            long prevVal = maxVal % restSum;
            if(prevVal == 0) return false;

            queue.offer((int)prevVal);
            totalSum = prevVal + restSum;
        }

        return true;
    }

    public boolean isPossible2(int[] target) {
        // 이걸 우선 순위 큐로 어떻게 푸냐
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);

        long totalSum = 0;
        for(int i : target){
            queue.offer(i);
            totalSum += i;
        }

        while(!queue.isEmpty()){
            int maxVal = queue.poll();
            long restSum = totalSum - maxVal;

            // 나머지 합이 1이면 가능
            if(maxVal == 1|| restSum == 1) return true;

            // 나머지 합이 최대값 미달이거나 0인 경우 불가
            if(restSum == 0 || maxVal <= restSum) return false;

            // 나머지 연산을 통해 이전 값 계산
            long prevVal = maxVal - restSum;
            if(prevVal <= 0) return false;

            queue.offer((int)prevVal);
            totalSum = prevVal + restSum;
        }

        return true;
    }
}
