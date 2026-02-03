package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3637_TrionicArrayI {

    @Test
    void test() {
        Assertions.assertTrue(isTrionic(new int[]{1, 2, 3, 2, 1, 2, 3}));
        Assertions.assertFalse(isTrionic(new int[]{1, 2, 3, 4, 5}));
        Assertions.assertFalse(isTrionic(new int[]{5, 4, 3, 2, 1}));
        Assertions.assertFalse(isTrionic(new int[]{1, 2, 2, 1}));
        Assertions.assertTrue(isTrionic(new int[]{1, 5, 2, 4}));
    }

    public boolean isTrionic(int[] nums) {
        // 올랐다 내렸다 하는지 보기?

        // q도 선택해야하기 때문에(nums.length-1)
        int n = nums.length;
        if(n == 3) return false;
        int p = -1;
        // 0 1 2 3 n-3 n-2 n-1
        for(int i = 0; i <= n-3; i++){
            if(nums[i] > nums[i+1]){
                // 꺽이는 부분
                p = i;
                if(i == 0) return false;
                break;
            } else if(nums[i] == nums[i+1]){
                return false;
            }
        }
        if(p == -1) return false;
        int q = -1;
        for(int i = p+1; i <= n-2; i++){
            if(nums[i] < nums[i+1]){
                q = i;
                break;
            } else if(nums[i] == nums[i+1]){
                return false;
            }
        }
        if(q == -1) return false;
        for(int i = q+1; i <= n-1; i++){
            if(nums[i] <= nums[i-1]){
                return false;
            }
        }
        return true;
    }
}
