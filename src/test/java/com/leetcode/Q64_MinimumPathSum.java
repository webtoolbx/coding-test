package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q64_MinimumPathSum {

    @Test
    void test() {
        System.out.println("result : " + minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println("result : " + minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    public int minPathSum(int[][] grid) {
        // 최소 값으로 더해가면 될거 같은데?
        // 1 1 부터?
        int y = grid.length;
        int x = grid[0].length;

        for (int i = 1; i < x; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < y; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                grid[j][i] += Math.min(grid[j][i - 1], grid[j - 1][i]);
            }
        }

        return grid[y - 1][x - 1];
    }

}
