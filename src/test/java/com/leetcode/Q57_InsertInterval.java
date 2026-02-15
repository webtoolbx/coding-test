package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q57_InsertInterval {

    @Test
    void test() {
        Q57_InsertInterval solution = new Q57_InsertInterval();

        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] expected1 = {{1, 5}, {6, 9}};
        Assertions.assertArrayEquals(expected1, solution.insert(intervals1, newInterval1));

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] expected2 = {{1, 2}, {3, 10}, {12, 16}};
        Assertions.assertArrayEquals(expected2, solution.insert(intervals2, newInterval2));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr = new int[intervals.length+1][2];
        for(int i = 0; i < intervals.length; i++){
            arr[i] = intervals[i];
        }
        arr[intervals.length] = newInterval;
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        int remove = 0;
        for(int i = 0; i < arr.length; i++){
            int idx = i+1;
            boolean isFind = false;
            while(idx < arr.length && arr[i][1] >= arr[idx][0]){
                arr[i][1] = Math.max(arr[i][1], arr[idx][1]);
                arr[idx] = null;
                remove++;
                idx++;
                isFind = true;
            }
            if(isFind) break;
        }
        int[][] answer = new int[arr.length-remove][2];
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                answer[idx] = arr[i];
                idx++;
            }
        }

        return answer;
    }
}
