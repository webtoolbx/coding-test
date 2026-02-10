package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q3719_LongestBalancedSubarrayI {

    @Test
    void test() {
        Assertions.assertEquals(4, longestBalanced(new int[]{1, 2, 3, 4}));
        Assertions.assertEquals(2, longestBalanced(new int[]{1, 1, 2, 2}));
        Assertions.assertEquals(0, longestBalanced(new int[]{1, 3, 5}));
        Assertions.assertEquals(0, longestBalanced(new int[]{2, 4, 6}));
    }

    public int longestBalanced(int[] nums) {
        // 0부터 시작하는 subArray ~
        int answer = 0;
        for(int i = 0; i < nums.length; i++){
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            for(int j = i; j < nums.length; j++){
                if(nums[j] % 2 == 0){
                    even.add(nums[j]);
                } else {
                    odd.add(nums[j]);
                }
                if(even.size() == odd.size()){
                    answer = Math.max(answer, j-i+1);
                }
            }
        }
        return answer;
    }
}
