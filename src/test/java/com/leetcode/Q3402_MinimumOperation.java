package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q3402_MinimumOperation {

    @Test
    void test() {
        System.out.println(minimumOperations(new int[][]{{3,2},{1,3},{3,4},{0,1}}));
        System.out.println(minimumOperations(new int[][]{{3,2,1},{2,1,0},{1,2,3}}));
    }

    public int minimumOperations(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int prev =  grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                if(grid[j][i] <= prev){
                    answer += prev + 1 - grid[j][i];
                    prev++;
                } else {
                    prev = grid[j][i];
                }
            }
        }
        return answer;
    }
}
