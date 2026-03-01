package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixMultiplication {

    @Test
    void test() {
        MatrixMultiplication solution = new MatrixMultiplication();
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        int[][] expected1 = {{15, 15}, {15, 15}, {15, 15}};
        Assertions.assertArrayEquals(expected1, solution.solution(arr1, arr2));

        int[][] arr3 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr4 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        int[][] expected2 = {{22, 22, 11}, {36, 28, 18}, {29, 20, 14}};
        Assertions.assertArrayEquals(expected2, solution.solution(arr3, arr4));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
                // arr1 은 i 고정
                // arr2 은 j 고정
                for(int k = 0; k < arr1[0].length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
