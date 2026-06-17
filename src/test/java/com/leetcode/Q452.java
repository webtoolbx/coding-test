package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q452 {

    @Test
    void test() {
        Assertions.assertEquals(2, findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        Assertions.assertEquals(4, findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        Assertions.assertEquals(2, findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
    }

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;

        // greedy 방식으로 접근
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int cnt = 1;
        int arrow = points[0][1];

        for(int i = 0; i < points.length; i++){
            if(points[i][0] > arrow){
                arrow = points[i][1];
                cnt++;
                continue;
            }
        }

        return cnt;
    }
}
