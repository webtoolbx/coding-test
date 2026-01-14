package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q54_Spiral_Matrix {

    @Test
    void test() {
        Assertions.assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Assertions.assertEquals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int count = matrix.length * matrix[0].length;
        int x = 0, y = 0;
        int xMin = 0, yMin = 0;
        int xMax = matrix[0].length-1, yMax = matrix.length-1;
        int cur = 0;
        while(count > 0){
            answer.add(matrix[y][x]);
            if(cur == 0){
                if(x+1 <= xMax){
                    x++;
                } else {
                    yMin++;
                    y++;
                    cur++;
                }
            } else if(cur == 1){
                if(y+1 <= yMax){
                    y++;
                } else {
                    xMax--;
                    x--;
                    cur++;
                }
            } else if(cur == 2){
                if(x > xMin){
                    x--;
                } else {
                    yMax--;
                    y--;
                    cur++;
                }
            } else {
                if(y > yMin){
                    y--;
                } else {
                    xMin++;
                    x++;
                    cur = 0;
                }
            }
            count--;
        }
        return answer;
    }
}
