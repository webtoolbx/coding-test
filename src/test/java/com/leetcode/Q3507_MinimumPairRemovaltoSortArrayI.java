package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3507_MinimumPairRemovaltoSortArrayI {

    @Test
    void test() {
        Assertions.assertEquals(2, minimumPairRemoval(new int[]{5, 3, 4, 2, 1}));
        Assertions.assertEquals(0, minimumPairRemoval(new int[]{1, 2, 3, 4, 5}));
        Assertions.assertEquals(3, minimumPairRemoval(new int[]{5, 4, 3, 2, 1}));
    }

    public int minimumPairRemoval(int[] nums) {
        // 작아지는 값들.. 생각보다 길이가 짧네?
        // 가장 작은 값 쌍을 추출
        int n = nums.length;
        while(n != 1){
            // non-decreasing
            boolean isNonDecreasing = true;
            for(int i = 1; i < n; i++){
                if(nums[i] < nums[i-1]){
                    isNonDecreasing = false;
                    break;
                }
            }
            if(isNonDecreasing){
                return nums.length - n;
            }

            // get minimum
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int i = 1; i < n; i++){
                if(nums[i] + nums[i-1] < min){
                    min = nums[i] + nums[i-1];
                    idx = i-1;
                }
            }
            nums[idx] = min;
            for(int i = idx+1; i < n-1; i++){
                nums[i] = nums[i+1];
            }
            n--;
        }
        return nums.length - n;
    }
}
