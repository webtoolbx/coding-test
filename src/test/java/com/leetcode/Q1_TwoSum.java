package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q1_TwoSum {

    @Test
    void test() {
        Assertions.assertArrayEquals(twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});
        Assertions.assertArrayEquals(twoSum2(new int[]{2,7,11,15}, 9), new int[]{0,1});
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

    public int[] twoSum2(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            list.add(n);
        }
        Collections.sort(list);
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            long sum = list.get(left) + list.get(right);
            if(sum > target){
                right--;
            } else if(sum == target){
                break;
            } else {
                left++;
            }
        }

        int l = list.get(left);
        int r = list.get(right);

        // System.out.println(l);
        // System.out.println(r);

        int[] answer = new int[]{-1,-1};
        for(int i = 0; i < nums.length; i++){
            // System.out.println(nums[i]);
            if(nums[i] == l && answer[0] == -1){
                answer[0] = i;
            } else if(nums[i] == r){
                answer[1] = i;
            }
        }

        return answer;
    }
}
