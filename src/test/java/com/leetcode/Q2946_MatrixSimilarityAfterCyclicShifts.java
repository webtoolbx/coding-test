package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2946_MatrixSimilarityAfterCyclicShifts {

    @Test
    void test() {
        Q2946_MatrixSimilarityAfterCyclicShifts solution = new Q2946_MatrixSimilarityAfterCyclicShifts();

        // Test Case 1: Example from problem description - True
        int[][] mat1 = {{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}};
        int k1 = 2;
        Assertions.assertTrue(solution.areSimilar(mat1, k1));

        // Test Case 2: Example from problem description - False
        int[][] mat2 = {{2, 2}, {2, 2}};
        int k2 = 3;
        Assertions.assertFalse(solution.areSimilar(mat2, k2));

        // Test Case 3: Example from problem description - False
        int[][] mat3 = {{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}};
        int k3 = 1; // Should be false for k=1
        Assertions.assertFalse(solution.areSimilar(mat3, k3));

        // Test Case 4: k = 0, should always be true
        int[][] mat4 = {{1, 2}, {3, 4}};
        int k4 = 0;
        Assertions.assertTrue(solution.areSimilar(mat4, k4));

        // Test Case 5: k is a multiple of width, should be true
        int[][] mat5 = {{1, 2, 3}, {4, 5, 6}};
        int k5 = 3; // width is 3, k=3 means 0 shift
        Assertions.assertTrue(solution.areSimilar(mat5, k5));

        // Test Case 6: More complex case, true
        int[][] mat6 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        int k6 = 2;
        Assertions.assertTrue(solution.areSimilar(mat6, k6)); // Row 0: 1234 -> 3412. Row 1: 5678 -> 7856. All similar.

        // Test Case 7: More complex case, false
        int[][] mat7 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        int k7 = 1;
        Assertions.assertFalse(solution.areSimilar(mat7, k7));
    }

    public boolean areSimilar(int[][] mat, int k) {
        int h = mat.length;
        int w = mat[0].length;
        k = k % w;
        for(int i = 0; i < h; i++){
            // 각 높이에서 비교 필요
            if(i % 2 == 0){ // Even rows shift right
                for(int j = 0; j < w; j++){
                    int right = (j + k) % w;
                    if(mat[i][j] != mat[i][right]){
                        return false;
                    }
                }
            } else { // Odd rows shift left
                for(int j = 0; j < w; j++){
                    int left = (j - k + w) % w; // Ensure positive index
                    if(mat[i][j] != mat[i][left]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
