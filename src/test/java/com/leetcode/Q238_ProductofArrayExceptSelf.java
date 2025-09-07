package com.leetcode;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Q238_ProductofArrayExceptSelf {

    @Test
    void test() {
        System.out.println("result : " + productExceptSelf(new int[]{1,2,3,4,5}));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);

        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for(int i = n-1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }
}
