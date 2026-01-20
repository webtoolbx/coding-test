package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1292_MaximumSideLengthofaSquare {

    @Test
    void test() {
        Assertions.assertEquals(2, maxSideLength(new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}}, 4));
        Assertions.assertEquals(0, maxSideLength(new int[][]{{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}}, 1));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        // dp 로 하면 조금 줄일 수 있네?
        // 다 구하는데 약간의 dp를 섞은
        int size = Math.min(mat.length, mat[0].length);
        int[][] dp = new int[mat.length][mat[0].length+1];
        for(int i = 0; i < mat.length; i++){
            int sum = 0;
            for(int j = 0; j < mat[0].length; j++){
                sum += mat[i][j];
                dp[i][j+1] = sum;
            }
        }
        while(size > 0){
            for(int i = 0; i <= mat.length-size; i++){
                for(int j = 0; j <= mat[0].length-size; j++){
                    if(cal(dp, i, j, size, threshold)){
                        return size;
                    }
                }
            }
            size--;
        }

        return size;
    }

    private boolean cal(int[][] dp, int y, int x, int size, int threshold){
        int sum = 0;
        for(int i = y; i < y + size; i++){
            sum+=(dp[i][x+size] - dp[i][x]);
        }

        return sum <= threshold;
    }
}
