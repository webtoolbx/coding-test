package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q401_BinaryWatch {

    @Test
    void test() {
        Q401_BinaryWatch solution = new Q401_BinaryWatch();

        List<String> result1 = solution.readBinaryWatch(1);
        Assertions.assertTrue(result1.contains("1:00"));
        Assertions.assertTrue(result1.contains("2:00"));
        Assertions.assertTrue(result1.contains("4:00"));
        Assertions.assertTrue(result1.contains("8:00"));
        Assertions.assertTrue(result1.contains("0:01"));
        Assertions.assertTrue(result1.contains("0:02"));
        Assertions.assertTrue(result1.contains("0:04"));
        Assertions.assertTrue(result1.contains("0:08"));
        Assertions.assertTrue(result1.contains("0:16"));
        Assertions.assertTrue(result1.contains("0:32"));

        List<String> result2 = solution.readBinaryWatch(9);
        Assertions.assertTrue(result2.isEmpty());
    }

    // DFS Combination
    Set<Integer> hourSet;
    Set<Integer> minutesSet;

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> answer = new ArrayList<>();
        int[] hourArr = new int[]{1,2,4,8};
        int[] minutesArr = new int[]{1,2,4,8,16,32};

        for(int i = 0; i <= turnedOn; i++){
            int hourCount = i;
            int minuteCount = turnedOn - i;

            if(hourCount > 4 || minuteCount > 6) continue;

            hourSet = new HashSet<>();
            boolean[] visitedHour = new boolean[hourArr.length];
            combination(hourArr, visitedHour, 0, hourArr.length, hourCount, true);

            minutesSet = new HashSet<>();
            boolean[] visitedMinute = new boolean[minutesArr.length];
            combination(minutesArr, visitedMinute, 0, minutesArr.length, minuteCount, false);

            for(int h : hourSet){
                for(int m : minutesSet){
                    answer.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return answer;
    }

    public void combination(int[] arr, boolean[] visited, int start, int n, int r, boolean isHour){
        if(r == 0){
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(visited[i]){
                    sum += arr[i];
                }
            }
            if(isHour){
                if(sum < 12) hourSet.add(sum);
            } else {
                if(sum < 60) minutesSet.add(sum);
            }
            return;
        }

        for(int i = start; i < n; i++){
            visited[i] = true;
            combination(arr, visited, i+1, n, r-1, isHour);
            visited[i] = false;
        }
    }
}
