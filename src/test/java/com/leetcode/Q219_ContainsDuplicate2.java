package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q219_ContainsDuplicate2 {

    @Test
    void test() {
        Assertions.assertTrue(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        Assertions.assertTrue(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        Assertions.assertFalse(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));

        Assertions.assertTrue(containsNearbyDuplicate2(new int[]{1, 2, 3, 1}, 3));
        Assertions.assertTrue(containsNearbyDuplicate2(new int[]{1, 0, 1, 1}, 1));
        Assertions.assertFalse(containsNearbyDuplicate2(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length && j - i <= k; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
