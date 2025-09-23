package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q1679_MaxNumberofKSumPairs {

    @Test
    void test() {
        System.out.println(maxOperations(new int[]{1,2,3,4}, 5));
    }

    public int maxOperations(int[] nums, int k) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            Integer cnt = map.get(k - n);
            if(cnt != null){
                answer++;
                if(cnt == 1){
                    map.remove(k - n);
                } else {
                    map.put(k - n, cnt - 1);
                }
            } else {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }

        return answer;
    }
}
