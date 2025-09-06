package com.leetcode;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class Q739_DailyTemperatures {

    @Test
    void test() {
        System.out.println("result : " + dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
        System.out.println("result : " + dailyTemperatures2(new int[]{73,74,75,71,69,72,76,73}));
    }

    // 노가다 방법은 time limit exceeded
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            for(int j = i+1; j < temperatures.length; j++){
                if(temperatures[j] > temperatures[i]){
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for(int i = temperatures.length-1; i >= 0; i--){
            int idx = 100000;
            for(int key : map.keySet()){
                if(key > temperatures[i]){
                    idx = Math.min(idx, map.get(key));
                }
            }
            if(idx < 100000){
                answer[i] = idx - i;
            }

            map.put(temperatures[i], i);
        }

        return answer;
    }

}
