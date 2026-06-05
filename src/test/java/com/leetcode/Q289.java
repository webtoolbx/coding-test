package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q289 {

    @Test
    void testGameOfLife() {
        Q289 solution = new Q289();

        // Test case 1: Example from LeetCode
        int[][] board1 = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        int[][] expected1 = {
            {0, 0, 0},
            {1, 0, 1},
            {0, 1, 1},
            {0, 1, 0}
        };
        solution.gameOfLife(board1);
        Assertions.assertArrayEquals(expected1, board1);

        // Test case 2: All dead cells
        int[][] board2 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int[][] expected2 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        solution.gameOfLife(board2);
        Assertions.assertArrayEquals(expected2, board2);

        // Test case 3: All live cells
        int[][] board3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int[][] expected3 = {
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 1}
        };
        solution.gameOfLife(board3);
        Assertions.assertArrayEquals(expected3, board3);

        // Test case 4: Single live cell (should die)
        int[][] board4 = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int[][] expected4 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        solution.gameOfLife(board4);
        Assertions.assertArrayEquals(expected4, board4);

        // Test case 5: Live cell with 2 neighbors (should live)
        int[][] board5 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int[][] expected5 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };
        solution.gameOfLife(board5);
        Assertions.assertArrayEquals(expected5, board5);

        // Test case 6: Live cell with 3 neighbors (should live)
        int[][] board6 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };
        int[][] expected6 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };
        solution.gameOfLife(board6);
        Assertions.assertArrayEquals(expected6, board6);

        // Test case 7: Dead cell with 3 neighbors (should become live)
        int[][] board7 = {
            {1, 1, 0},
            {1, 0, 0},
            {0, 0, 0}
        };
        int[][] expected7 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };
        solution.gameOfLife(board7);
        Assertions.assertArrayEquals(expected7, board7);
    }

    public void gameOfLife(int[][] board) {
        // 1 -> 1개 이하 -> 0
        // 1 -> 2개, 3개는 -> 1
        // 1 -> 4개 이상 -> 0
        // 0 -> 정확히 3개 -> 1

        // MVCC 마냥 이전 데이터를 가지고 있어야하네?
        // 복사해두고 다시 옮겨 담아야겠다
        int[][] copy = new int[board.length][board[0].length];
        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[0].length; x++){
                boolean live = board[y][x] == 1;
                int cnt = count(board, y, x);
                if(live){
                    if(cnt == 2 || cnt == 3){
                        copy[y][x] = 1;
                    }
                } else {
                    if(cnt == 3){
                        copy[y][x] = 1;
                    }
                }
            }
        }

        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[0].length; x++){
                board[y][x] = copy[y][x];
            }
        }
    }

    private int count(int[][] board, int y, int x){
        int minY = Math.max(0, y-1);
        int maxY = Math.min(board.length-1, y+1);
        int minX = Math.max(0, x-1);
        int maxX = Math.min(board[0].length-1, x+1);
        int cnt = 0;
        for(int i = minY; i <= maxY; i++){
            for(int j = minX; j <= maxX; j++){
                if(i == y && j == x){
                    continue;
                }
                if(board[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
