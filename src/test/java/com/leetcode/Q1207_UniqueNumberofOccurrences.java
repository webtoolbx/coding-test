package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Q1207_UniqueNumberofOccurrences {

    @Test
    void test() {
        System.out.println("result : " + uniqueOccurrences(new int[]{1,1,2,1,2,3}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return map.values().stream().count() == map.values().stream().collect(Collectors.toSet()).stream().count() ? true : false;
    }

    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(int i : map.values()){
            if(set.contains(i)){
                return false;
            } else {
                set.add(i);
            }
        }
        return true;
    }
}
