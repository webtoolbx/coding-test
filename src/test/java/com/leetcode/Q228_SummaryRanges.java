package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q228_SummaryRanges {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
        Assertions.assertEquals(List.of("0->2", "4->5", "7"), summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        Assertions.assertEquals(List.of("0", "2->4", "6", "8->9"), summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        // array 개수가 적으니 array 를 순회하는 방식이 좋음
        List<String> list = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        numList.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(numList.get(numList.size()-1) + 1 != nums[i]){
                // numList 를 list 로 입력
                if(numList.size() == 1){
                    list.add(String.valueOf(numList.get(0)));
                } else {
                    list.add(String.format("%d->%d", numList.get(0), numList.get(numList.size()-1)));
                }
                numList = new ArrayList<>();
                numList.add(nums[i]);
            } else {
                numList.add(nums[i]);
            }
        }
        if(numList.size() == 1){
            list.add(String.valueOf(numList.get(0)));
        } else {
            list.add(String.format("%d->%d", numList.get(0), numList.get(numList.size()-1)));
        }

        return list;
    }
}
