package com.leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class Q3005_CountElementsWithMaximumFrequency {

    @Test
    void test() {
        System.out.println("result : " + maxFrequencyElements(new int[]{1,2,3,1,2,3}));
    }

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums){
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
            max = Math.max(cnt, max);
        }
        int cnt = 0;
        for(int key : map.keySet()){
            if(max == map.get(key)){
                cnt++;
            }
        }
        return max * cnt;
    }
}
