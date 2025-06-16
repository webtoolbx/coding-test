package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q2016_MaximumDifference {

    @Test
    void test() {
        int result = maximumDifference(new int[]{1,5,2,10});
        System.out.println(result);
    }

    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int premin = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] > premin){
                ans = Math.max(ans, nums[i] - premin);
            } else {
                premin = nums[i];
            }
        }
        return ans;
    }
}
