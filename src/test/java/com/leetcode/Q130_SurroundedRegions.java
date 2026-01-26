package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q130_SurroundedRegions {

    @Test
    void test() {
        // Case 1
        char[][] board1 = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        char[][] expected1 = {
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        solve(board1);
        Assertions.assertArrayEquals(expected1, board1);

        // Case 2
        char[][] board2 = {
            {'X'}
        };
        char[][] expected2 = {
            {'X'}
        };
        solve(board2);
        Assertions.assertArrayEquals(expected2, board2);
    }

    public void solve(char[][] board) {
        int y = board.length, x = board[0].length;
        boolean[][] isVisited = new boolean[y][x];
        Set<String> change = new HashSet<>();
        Set<String> phase = new HashSet<>();

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(board[i][j] == 'O' && !isVisited[i][j]){
                    phase = new HashSet<>();
                    boolean result = dfs(i, j, phase, isVisited, board);
                    if(result){
                        change.addAll(phase);
                    }
                }
            }
        }
        for(String s : change){
            String[] arr = s.split(":");
            int i = Integer.parseInt(arr[0]);
            int j = Integer.parseInt(arr[1]);
            board[i][j] = 'X';
        }
    }

    private boolean dfs(int i, int j, Set<String> phase, boolean[][] isVisited, char[][] board){
        if(isVisited[i][j]) return true;
        if(board[i][j] == 'X') return true;

        phase.add(i + ":" + j);
        isVisited[i][j] = true;
        boolean result = true;
        if(i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1){
            result = false;
        }


        if(i-1 >= 0){
            if(!dfs(i-1, j, phase, isVisited, board)){
                result = false;
            }
        }
        if(i+1 <= board.length-1){
            if(!dfs(i+1, j, phase, isVisited, board)){
                result = false;
            }
        }
        if(j-1 >= 0){
            if(!dfs(i, j-1, phase, isVisited, board)){
                result = false;
            }
        }
        if(j+1 <= board[0].length-1){
            if(!dfs(i, j+1, phase, isVisited, board)){
                result = false;
            }
        }
        return result;
    }
}
