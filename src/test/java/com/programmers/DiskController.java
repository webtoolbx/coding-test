package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DiskController {

    @Test
    void test() {
        Solution solution = new Solution();
        Assertions.assertEquals(9, solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    class Solution {
        public int solution(int[][] jobs) {
            Arrays.sort(jobs, (a, b) -> {return Integer.compare(a[0], b[0]);});
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1[1] != o2[1]) return o1[1] - o2[1];
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[2] - o2[2];});

            int i = 0;
            int n = jobs.length;
            int idx = 0;
            List<Integer> list = new ArrayList<>();
            while(true){
                while(idx < n && jobs[idx][0] <= i){
                    pq.add(new int[]{jobs[idx][0], jobs[idx][1], idx});
                    idx++;
                }
                if(!pq.isEmpty()){
                    int[] arr = pq.poll();
                    list.add(i + arr[1] - arr[0]);
                    i = i + arr[1];
                } else {
                    i++;
                }

                if(idx >= n && pq.isEmpty()){
                    break;
                }
            }

            int sum = 0;
            for(int z : list){
                sum += z;
            }

            return sum / list.size();
        }
    }
}
