package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class Q209_MinimumSizeSubarraySum {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
        Assertions.assertEquals(2, minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        Assertions.assertEquals(1, minSubArrayLen(4, new int[]{1,4,4}));
        Assertions.assertEquals(0, minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    // #sliding
    public int minSubArrayLen(int target, int[] nums) {
        // 그래도 음수는 없는데? -> 슬라이딩 윈도
        // 오른쪽을 추가하면서 왼쪽 내용을 삭제
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
