package com.leetcode;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Q435_NonoverlappingIntervals {

    @Test
    void test() {
        System.out.println("result : " + eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int prev = -5 * 10000;
        int res = 0;

        for(int[] arr : intervals){
            if(prev > arr[0]){
                res++;
            } else {
                prev = arr[1];
            }
        }

        return res;
    }
}
