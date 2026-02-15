package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q73_SetMatrixZeroes {

    @Test
    void test() {
        Q73_SetMatrixZeroes solution = new Q73_SetMatrixZeroes();

        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] expected1 = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        solution.setZeroes(matrix1);
        Assertions.assertArrayEquals(expected1, matrix1);

        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] expected2 = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        solution.setZeroes(matrix2);
        Assertions.assertArrayEquals(expected2, matrix2);
    }

    public void setZeroes(int[][] matrix) {
        int y = matrix.length;
        int x = matrix[0].length;
        boolean[] yArr = new boolean[y];
        boolean[] xArr = new boolean[x];

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(matrix[i][j] == 0){
                    yArr[i] = true;
                    xArr[j] = true;
                }
            }
        }

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(yArr[i] || xArr[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
