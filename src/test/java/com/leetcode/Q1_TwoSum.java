package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {

    @Test
    void test() {
        Assertions.assertArrayEquals(twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int sub = target - nums[i];
            if(map.containsKey(sub)){
                return new int[]{map.get(sub), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
