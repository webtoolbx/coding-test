package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q88_mergeSortedArray {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
    }

    // #PriorityQueue
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < m; i++){
            queue.offer(nums1[i]);
        }
        for(int i = 0; i < n; i++){
            queue.offer(nums2[i]);
        }
        int idx = 0;
        while(!queue.isEmpty()){
            nums1[idx] = queue.poll();
            idx++;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        n--;
        m--;

        for(int i = nums1.length - 1; i >= 0; i--){
            if(m < 0){
                nums1[i] = nums2[n];
                n--;
            } else if(n < 0){
                nums1[i] = nums1[m];
                m--;
            } else if(nums1[m] > nums2[n]){
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
        }
    }
}
