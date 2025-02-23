package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    @Test
    void addition() {
        int[] data = twoSum(new int[]{2,7,11,15}, 9);
        System.out.print(data[0]);
        System.out.print(data[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int pre = target - nums[i];
            if(map.containsKey(pre)){
                return new int[]{i, map.get(pre)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
