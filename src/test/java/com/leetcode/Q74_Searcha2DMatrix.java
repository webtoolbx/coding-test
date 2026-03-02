package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q74_Searcha2DMatrix {

    @Test
    void test() {
        Q74_Searcha2DMatrix solution = new Q74_Searcha2DMatrix();
        Assertions.assertTrue(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        Assertions.assertFalse(solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int y = 0;
        for(int i = 0; i < matrix.length; i++){
            if(target > matrix[i][0]){
                y = i;
            } else if(target == matrix[i][0]){
                return true;
            } else {
                break;
            }
        }
        // System.out.println(y);
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[y][i] == target){
                return true;
            }
        }

        return false;
    }
}
