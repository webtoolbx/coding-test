package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class Q2561_RearrangingFruits {

    @Test
    void test() {

    }

    public long minCost(int[] basket1, int[] basket2) {
        // 무조건 두 배열이 동일해야하는구나
        Map<Integer, Integer> map1 = new HashMap<>();
        SortedMap<Integer, Integer> mergeMap = new TreeMap<>();
        for(int b : basket1){
            map1.put(b, map1.getOrDefault(b, 0) + 1);
            mergeMap.put(b, mergeMap.getOrDefault(b, 0) + 1);
        }
        for(int b : basket2){
            mergeMap.put(b, mergeMap.getOrDefault(b, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : mergeMap.entrySet()){
            if(entry.getValue() % 2 != 0) return -1;
            int diff = Math.abs(entry.getValue() / 2 - map1.getOrDefault(entry.getKey(), 0));
            for(int i = 0; i < diff; i++){
                list.add(entry.getKey());
            }
        }

        long answer = 0;
        for(int i = 0; i < list.size() / 2; i++){
            answer += Math.min(mergeMap.firstKey() * 2,list.get(i));
        }

        return answer;
    }
}
