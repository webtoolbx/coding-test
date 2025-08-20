package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q643_MaximumAverageSubarrayI {

    @Test
    void test() {
        System.out.println(findMaxAverageUsingQueue(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(findMaxAverageUsingArray(new int[]{1,12,-5,-6,50,3}, 4));
    }

    // Good memory
    public double findMaxAverageUsingArray(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        double answer = (double) sum / k;

        int size = nums.length;
        for(int i = k; i < size; i++){
            int diff = nums[i] - nums[i-k];
            sum += diff;
            if(diff > 0){
                answer = Math.max(answer, (double) sum / k);
            }
        }

        return answer;
    }

    // Good memory
    public double findMaxAverageUsingQueue(int[] nums, int k) {

        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < k; i++){
            queue.add(nums[i]);
            sum += nums[i];
        }

        double answer = (double) sum / k;
        int size = nums.length;
        for(int i = k; i < size; i++){
            sum -= queue.poll();
            sum += nums[i];
            answer = Math.max(answer, (double) sum / k);
            queue.add(nums[i]);
        }

        return answer;
    }
}
