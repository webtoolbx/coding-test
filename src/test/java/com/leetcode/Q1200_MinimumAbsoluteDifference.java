package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1200_MinimumAbsoluteDifference {

    @Test
    void test() {
        Assertions.assertEquals(List.of(List.of(1, 2), List.of(2, 3), List.of(3, 4)), minimumAbsDifference(new int[]{4, 2, 1, 3}));
        Assertions.assertEquals(List.of(List.of(1, 3)), minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        Assertions.assertEquals(List.of(List.of(-14, -10), List.of(19, 23), List.of(23, 27)), minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++){
            int diff = arr[i] - arr[i-1];
            if(diff < min){
                min = diff;
                list = new ArrayList<>();
                list.add(List.of(arr[i-1], arr[i]));
            } else if(diff == min){
                list.add(List.of(arr[i-1], arr[i]));
            }
        }
        return list;
    }
}
