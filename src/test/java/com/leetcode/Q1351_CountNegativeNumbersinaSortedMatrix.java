package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1351_CountNegativeNumbersinaSortedMatrix {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
        int[][] grid1 = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        Assertions.assertEquals(8, countNegatives(grid1));
        Assertions.assertEquals(8, countNegatives2(grid1));
        Assertions.assertEquals(8, countNegativesOptimal(grid1));

        int[][] grid2 = {{3, 2}, {1, 0}};
        Assertions.assertEquals(0, countNegatives(grid2));
        Assertions.assertEquals(0, countNegatives2(grid2));
        Assertions.assertEquals(0, countNegativesOptimal(grid2));
    }

    // BFS very slow
    public int countNegatives(int[][] grid) {
        // BFS?
        int ans = grid.length * grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // row and column
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            if(grid[r][c] >= 0){
                ans--;
                if(r+1 < grid.length && !visited[r+1][c]){
                    visited[r+1][c] = true;
                    queue.add(new int[]{r+1, c});
                }
                if(c+1 < grid[0].length && !visited[r][c+1]){
                    visited[r][c+1] = true;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        return ans;
    }

    // if you find negative stop the search
    public int countNegatives2(int[][] grid) {
        int ans = grid.length * grid[0].length;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] < 0){
                    break;
                }
                ans--;
            }
        }
        return ans;
    }

    // O(m + n) solution
    // Start from bottom-left or top-right to utilize the sorted property
    public int countNegativesOptimal(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int r = rows - 1;
        int c = 0;

        while (r >= 0 && c < cols) {
            if (grid[r][c] < 0) {
                count += (cols - c);
                r--;
            } else {
                c++;
            }
        }
        return count;
    }
}
