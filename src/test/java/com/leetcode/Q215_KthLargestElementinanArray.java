package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Q215_KthLargestElementinanArray {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
        Assertions.assertEquals(5, findKthLargest1(new int[]{3,2,1,5,6,4}, 2));
        Assertions.assertEquals(4, findKthLargest1(new int[]{3,2,3,1,2,4,5,5,6}, 4));

        Assertions.assertEquals(5, findKthLargest2(new int[]{3,2,1,5,6,4}, 2));
        Assertions.assertEquals(4, findKthLargest2(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    // #TreeMap
    public int findKthLargest1(int[] nums, int k) {
        // 그냥 마지막에서 k 번째로 큰수 추출하기
        // 정렬 없이 할거면 SortedMap 활용?
        // 큰거에서 k 번째 할거면 작은거에서 nums.length - k 번째로 해도 되잖아?
        int idx = nums.length - k;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            idx = idx - entry.getValue();
            if(idx < 0){
                return entry.getKey();
            }
        }

        return 0;
    }

    // #PriorityQueue
    public int findKthLargest2(int[] nums, int k) {
        // PQ 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.offer(n);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
