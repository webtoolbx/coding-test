package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q198_HouseRobber {

    @Test
    void test() {
        Q198_HouseRobber solution = new Q198_HouseRobber();
        Assertions.assertEquals(4, solution.rob(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(12, solution.rob(new int[]{2, 7, 9, 3, 1}));
        Assertions.assertEquals(0, solution.rob(new int[]{}));
        Assertions.assertEquals(1, solution.rob(new int[]{1}));
    }

    public int rob(int[] nums) {
        // 현재 집을 털지 않을 경우 nums[i-1]
        // 현재 집을 털고 전전집의 최대 값 nums[i-2] + nums[i]
        // 위 2개의 값 중 MAX
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1){
            return nums[0];
        } else if (n == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] max = new int[n];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            max[i] = Math.max(max[i-1], max[i-2] + nums[i]);
        }

        return max[n-1];
    }
}
