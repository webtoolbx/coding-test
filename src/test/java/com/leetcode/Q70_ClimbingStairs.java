package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q70_ClimbingStairs {

    @Test
    void test() {
        Assertions.assertEquals(2, climbStairs(2));
        Assertions.assertEquals(3, climbStairs(3));
        Assertions.assertEquals(5, climbStairs(4));
        Assertions.assertEquals(8, climbStairs(5));
    }

    // #Easy DP
    public int climbStairs(int n) {
        // 이거 진짜 DP다
        // 1 2 3 3+2 3+5
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
