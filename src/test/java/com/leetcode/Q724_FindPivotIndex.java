package com.leetcode;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Q724_FindPivotIndex {

    @Test
    void test() {
        System.out.println("result : " + pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    public int pivotIndex(int[] nums) {
        if(nums.length == 1) return 0;

        int left = 0;
        int right = Arrays.stream(nums).sum() - nums[0];

        if(left == right) return 0;

        for(int i = 1; i < nums.length; i++){
            right -= nums[i];
            left += nums[i-1];
            if(left == right) return i;
        }
        return -1;
    }
}
