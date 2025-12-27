package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Quest2_FindKPairswithSmallestSums {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(List.of(1, 2));
        expected1.add(List.of(1, 4));
        expected1.add(List.of(1, 6));
        Assertions.assertEquals(expected1, kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));

        List<List<Integer>> expected2 = new ArrayList<>();
        expected2.add(List.of(1, 1));
        expected2.add(List.of(1, 1));
        Assertions.assertEquals(expected2, kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
    }

    // #PriorityQueue
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.get(0) - o2.get(0);
        });
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            queue.offer(List.of(nums1[i] + nums2[0], i, 0));
        }

        while(k-- > 0 && !queue.isEmpty()){
            List<Integer> cur = queue.poll();
            int idx1 = cur.get(1);
            int idx2 = cur.get(2);

            list.add(List.of(nums1[idx1], nums2[idx2]));

            if(idx2 + 1 < nums2.length){
                queue.offer(List.of(nums1[idx1] + nums2[idx2+1], idx1, idx2+1));
            }
        }

        return list;
    }
}
