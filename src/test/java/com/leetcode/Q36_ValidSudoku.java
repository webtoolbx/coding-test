package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q36_ValidSudoku {

    @Test
    void test() {
        char[][] board1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Assertions.assertTrue(isValidSudoku(board1));

        char[][] board2 = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Assertions.assertFalse(isValidSudoku(board2));
    }

    public boolean isValidSudoku(char[][] board) {
        // 채워진 칸만 유효성 검사
        // 구역 별로 나눠서 확인
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> celMap = new HashMap<>();
        Map<Integer, Set<Character>> zoneMap = new HashMap<>();
        // 세로
        for(int i = 0; i < 9; i++){
            rowMap.put(i, new HashSet<Character>());
            celMap.put(i, new HashSet<Character>());
            zoneMap.put(i, new HashSet<Character>());
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char cur = board[i][j];
                if(cur == '.'){
                    continue;
                }
                int zoneKey = -1;
                if(i < 3){
                    if(j < 3){
                        zoneKey = 0;
                    } else if(j < 6){
                        zoneKey = 1;
                    } else {
                        zoneKey = 2;
                    }
                } else if(i < 6){
                    if(j < 3){
                        zoneKey = 3;
                    } else if(j < 6){
                        zoneKey = 4;
                    } else {
                        zoneKey = 5;
                    }
                } else {
                    if(j < 3){
                        zoneKey = 6;
                    } else if(j < 6){
                        zoneKey = 7;
                    } else {
                        zoneKey = 8;
                    }
                }

                Set<Character> rowSet = rowMap.get(i);
                Set<Character> celSet = celMap.get(j);
                Set<Character> zoneSet = zoneMap.get(zoneKey);

                if(rowSet.contains(cur)){
                    return false;
                } else {
                    rowSet.add(cur);
                    rowMap.put(i, rowSet);
                }
                if(celSet.contains(cur)){
                    return false;
                } else {
                    celSet.add(cur);
                    celMap.put(j, celSet);
                }
                if(zoneSet.contains(cur)){
                    return false;
                } else {
                    zoneSet.add(cur);
                    zoneMap.put(zoneKey, zoneSet);
                }
            }
        }

        return true;
    }
}
