package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q48_RotateImage {

    @Test
    void test() {
        Q48_RotateImage solution = new Q48_RotateImage();

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected1 = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        solution.rotate(matrix1);
        Assertions.assertArrayEquals(expected1, matrix1);

        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] expected2 = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        solution.rotate(matrix2);
        Assertions.assertArrayEquals(expected2, matrix2);
    }

    public void rotate(int[][] matrix) {
        // 대각선으로 바꾸기
        // 좌우 반전시키기
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
