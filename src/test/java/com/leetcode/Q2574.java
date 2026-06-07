package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2574 {

    @Test
    void testLeftRightDifference() {
        Q2574 solution = new Q2574();
        
        Assertions.assertArrayEquals(
            new int[]{15, 1, 11, 22}, 
            solution.leftRightDifference(new int[]{10, 4, 8, 3})
        );
        
        Assertions.assertArrayEquals(
            new int[]{0}, 
            solution.leftRightDifference(new int[]{1})
        );
        
        Assertions.assertArrayEquals(
            new int[]{2, 2}, 
            solution.leftRightDifference(new int[]{2, 2})
        );
    }

    public int[] leftRightDifference(int[] nums) {
        // 그냥 더해서 푼다면?
        int[] result = new int[nums.length];
        int[] leftSum = new int[nums.length];
        for(int i = 1; i < nums.length; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }
        int[] rightSum = new int[nums.length];
        for(int i = nums.length-2; i >= 0; i--){
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }

        for(int i = 0; i < nums.length; i++){
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return result;
    }
}
