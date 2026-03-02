package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1536_MinimumSwapstoArrangeaBinaryGrid {

    @Test
    void test() {
        Q1536_MinimumSwapstoArrangeaBinaryGrid solution = new Q1536_MinimumSwapstoArrangeaBinaryGrid();
        Assertions.assertEquals(3, solution.minSwaps(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}}));
        Assertions.assertEquals(-1, solution.minSwaps(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}}));
        Assertions.assertEquals(0, solution.minSwaps(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 1}}));
    }

    public int minSwaps(int[][] grid) {
        // grid[][1]이 0인 애를 맨 위로 올리기
        // grid[][2]이 0인 애를 2번째로 올리기
        // 불가능하다면 -1
        int answer = 0;

        List<int[]> list = new ArrayList<>();
        for(int[] g : grid){
            list.add(g);
        }

        int n = grid.length;
        for(int i = 1; i < n; i++){
            // i 부터 끝까지 0인 행 찾기
            int idx = -1;
            for(int j = 0; j < list.size(); j++){
                int[] row = list.get(j);
                boolean isValid = true;
                for(int k = i; k < n; k++){
                    if(row[k] == 1){
                        isValid = false;
                        break;
                    }
                }
                if(isValid){
                    idx = j;
                    break;
                }
            }
            if(idx == -1){
                return -1;
            }
            answer += idx;
            list.remove(idx);
        }

        return answer;
    }
}
