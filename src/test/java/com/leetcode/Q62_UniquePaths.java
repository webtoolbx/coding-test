package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q62_UniquePaths {

    @Test
    void test() {
        System.out.println("result : " + uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        // dp programming add the number all one
        int[][] map = new int[m][n];
        for(int i = 0; i < m; i++){
            map[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            map[0][i] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
