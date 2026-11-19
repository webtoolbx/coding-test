package com.leetcode;

import java.util.Arrays;

public class Q2567 {

    public int minimizeSum(int[] nums) {
        // 앞에서 2개
        // 앞뒤에서 1개씩
        // 뒤에서 2개
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(nums[n-3] - nums[0],
            Math.min(nums[n-2] - nums[1], nums[n-1] - nums[2]));
    }
}
