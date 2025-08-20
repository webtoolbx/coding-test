package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1127_CountSquareSubmatriceSwithAllOnes {

    @Test
    void test() {
        System.out.println("result : " + countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }));
    }

    public int countSquares(int[][] matrix) {
        int answer = 0;
        int maxY = matrix.length;
        int maxX = matrix[0].length;

        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                if(matrix[i][j] == 1){
                    if(i > 0 && j > 0){
                        matrix[i][j] = 1 + Math.min(matrix[i][j-1], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]));
                    }
                    answer += matrix[i][j];
                }
            }
        }

        return answer;
    }
}
