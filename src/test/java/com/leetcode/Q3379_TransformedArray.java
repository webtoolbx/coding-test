package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3379_TransformedArray {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1, 1, 1, 3}, constructTransformedArray(new int[]{3, -2, 1, 1}));
        Assertions.assertArrayEquals(new int[]{-1, -1, 4}, constructTransformedArray(new int[]{-1, 4, -1}));
    }

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < nums.length; i++){
            int idx = i + nums[i];
            // Use modulo operator for efficiency instead of while loop
            if (idx >= 0) {
                idx = idx % n;
            } else {
                idx = (idx % n + n) % n;
            }
            result[i] = nums[idx];
        }
        return result;
    }
}
