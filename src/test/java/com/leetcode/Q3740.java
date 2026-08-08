package com.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3740 {

    @Test
    void test() {
        assertThat(minimumDistance(new int[]{1,2,1,1,3})).isEqualTo(6);
    }

    public int minimumDistance(int[] nums) {
        // 똑같은거 3개 최소 거리
        // map 에 담아서 각각 비교해서 리턴

        int result = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        for(List<Integer> list : map.values()){
            if(list.size() < 3) continue;

            for(int i = 2; i < list.size(); i++){
                result = Math.min(result, Math.abs(list.get(i) - list.get(i-1)) + Math.abs(list.get(i) - list.get(i-2)) + Math.abs(list.get(i-1) - list.get(i-2)));
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
