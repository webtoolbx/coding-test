package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1861_RotatingtheBox {

    @Test
    void testRotateTheBox() {
        char[][] box1 = {{'#', '.', '#'}};
        char[][] expected1 = {{'.'}, {'#'}, {'#'}};
        char[][] actual1 = rotateTheBox(box1);
        Assertions.assertArrayEquals(expected1, actual1);

        char[][] box2 = {
                {'#', '#', '*', '.'},
                {'#', '#', '#', '*'}
        };
        char[][] expected2 = {
                {'#', '.'},
                {'#', '#'},
                {'*', '#'},
                {'*', '.'}
        };
        char[][] actual2 = rotateTheBox(box2);
        Assertions.assertArrayEquals(expected2, actual2);
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        int h = boxGrid.length;
        int w = boxGrid[0].length;

        // 일단 90도 회전
        char[][] box = new char[w][h];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                box[j][h - i - 1] = boxGrid[i][j];
            }
        }

        // 아래로 내리기
        int nh = box.length;
        int nw = box[0].length;
        for (int i = 0; i < nw; i++) {
            int empty = nh - 1;
            for (int j = nh - 1; j >= 0; j--) {
                if (box[j][i] == '*') {
                    empty = j - 1;
                } else if (box[j][i] == '#') {
                    box[j][i] = '.';
                    box[empty][i] = '#';
                    empty--;
                }
            }
        }

        return box;
    }
}