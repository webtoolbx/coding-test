package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q1004_MaxConsecutiveOnesIII {

    @Test
    void test() {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 3));
    }

    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int start = 0;
        int answer = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
            }
            answer = Math.max(answer, i - start + 1);
        }
        return answer;
    }
}
