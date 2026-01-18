package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Q1895_LargestMagicSquare {

    @Test
    void test() {
        Assertions.assertEquals(3, largestMagicSquare(new int[][]{{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}}));
        Assertions.assertEquals(2, largestMagicSquare(new int[][]{{5,1,3,1},{9,3,3,1},{1,3,3,8}}));
    }

    public int largestMagicSquare(int[][] grid) {
        int size = Math.min(grid.length, grid[0].length);
        while(size > 1){
            for(int i = 0; i <= grid.length - size; i++){
                for(int j = 0; j <= grid[0].length - size; j++){
                    if(valid(grid, i, j, size)){
                        return size;
                    }
                }
            }
            size--;
        }
        return 1;
    }

    private boolean valid(int[][] grid, int y, int x, int size){
        int sum = 0;
        for(int i = y; i < y + size; i++){
            int tempSum = 0;
            for(int j = x; j < x + size; j++){
                tempSum += grid[i][j];
            }
            if(sum == 0) sum = tempSum;
            if(sum != tempSum) return false;
        }
        for(int i = x; i < x + size; i++){
            int tempSum = 0;
            for(int j = y; j < y + size; j++){
                tempSum += grid[j][i];
            }
            if(sum != tempSum) return false;
        }
        int tempSum = 0;
        int idx = y;
        for(int i = x; i < x+size; i++){
            tempSum += grid[idx][i];
            idx++;
        }
        if(sum != tempSum) return false;
        tempSum = 0;
        for(int i = x+size-1; i >= x; i--){
            tempSum += grid[y][i];
            y++;
        }
        if(sum != tempSum) return false;
        return true;
    }
}
