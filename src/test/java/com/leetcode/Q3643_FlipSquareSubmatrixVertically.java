package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3643_FlipSquareSubmatrixVertically {

    @Test
    void test() {
        Q3643_FlipSquareSubmatrixVertically solution = new Q3643_FlipSquareSubmatrixVertically();

        // Test Case 1: Simple 3x3 grid, reverse 2x2 submatrix at (0,0)
        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected1 = {{4, 5, 3}, {1, 2, 6}, {7, 8, 9}};
        Assertions.assertArrayEquals(expected1, solution.reverseSubmatrix(grid1, 0, 0, 2));

        // Test Case 2: Simple 3x3 grid, reverse 2x2 submatrix at (1,1)
        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected2 = {{1, 2, 3}, {4, 8, 9}, {7, 5, 6}};
        Assertions.assertArrayEquals(expected2, solution.reverseSubmatrix(grid2, 1, 1, 2));

        // Test Case 3: k=1 (no change)
        int[][] grid3 = {{1, 2}, {3, 4}};
        int[][] expected3 = {{1, 2}, {3, 4}};
        Assertions.assertArrayEquals(expected3, solution.reverseSubmatrix(grid3, 0, 0, 1));

        // Test Case 4: Full grid reverse
        int[][] grid4 = {{1, 2}, {3, 4}};
        int[][] expected4 = {{3, 4}, {1, 2}};
        Assertions.assertArrayEquals(expected4, solution.reverseSubmatrix(grid4, 0, 0, 2));
    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int h = grid.length;
        int w = grid[0].length;
        int[][] answer = new int[h][w];
        double div = (double) x + (double)((k-1) / 2.0);
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(i >= x && i < x + k && j >= y && j < y + k){
                    int p = (int) (2 * div) - i;
                    answer[i][j] = grid[p][j];
                } else {
                    answer[i][j] = grid[i][j];
                }
            }
        }
        return answer;
    }
}
