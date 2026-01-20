package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q45_JumpGame2 {

    @Test
    void test() {
        Assertions.assertEquals(2, jump(new int[]{2,3,1,1,4}));
        Assertions.assertEquals(2, jump(new int[]{2,3,0,1,4}));
        Assertions.assertEquals(0, jump(new int[]{0}));
    }

    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        // 이전에 뛴 곳 중 가장 먼 곳을 선택해가기
        int ans = 1;
        int min = 0;
        int max = 0;
        while (ans <= nums.length - 1){
            // 새로 늘어난 영역에 대해서만 처리한다
            int curMax = Integer.MIN_VALUE;
            for(int i = min; i <= max; i++){
                curMax = Math.max(curMax, i + nums[i]);
            }
            min = max + 1;
            max = curMax;
            if(max >= nums.length - 1) return ans;
            ans++;
        }
        return ans;
    }

}
