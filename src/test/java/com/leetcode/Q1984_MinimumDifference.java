package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q1984_MinimumDifference {

    @Test
    void test() {
        Assertions.assertEquals(2, minimumDifference(new int[]{90}, 1));
        Assertions.assertEquals(2, minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }

    public int minimumDifference(int[] nums, int k) {
        if(k == 1) return 0;
        Arrays.sort(nums);
        int min = 100001;
        int n = nums.length;
        for(int i = 0; i <= n - k; i++){
            min = Math.min(min, nums[i+k-1] - nums[i]);
        }
        return min;
    }
}
