package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q63_UniquePathsII {

    @Test
    void test() {
        Q63_UniquePathsII solution = new Q63_UniquePathsII();
        Assertions.assertEquals(2, solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        Assertions.assertEquals(1, solution.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        Assertions.assertEquals(0, solution.uniquePathsWithObstacles(new int[][]{{1}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // DP problem
        int x = obstacleGrid[0].length;
        int y = obstacleGrid.length;

        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        int[][] grid = new int[y][x];
        grid[0][0] = 1;
        for(int i = 1; i < x; i++){
            if(obstacleGrid[0][i] == 0){
                grid[0][i] += grid[0][i-1];
            }
        }
        for(int i = 1; i < y; i++){
            if(obstacleGrid[i][0] == 0){
                grid[i][0] += grid[i-1][0];
            }
        }

        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                if(obstacleGrid[j][i] == 0){
                    grid[j][i] = grid[j][i-1] + grid[j-1][i];
                }
            }
        }

        return grid[y-1][x-1];
    }
}
