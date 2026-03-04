package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q1582_SpecialPositionsinaBinaryMatrix {

    @Test
    void test() {
        Q1582_SpecialPositionsinaBinaryMatrix solution = new Q1582_SpecialPositionsinaBinaryMatrix();
        Assertions.assertEquals(1, solution.numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
        Assertions.assertEquals(3, solution.numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        Assertions.assertEquals(2, solution.numSpecial(new int[][]{{0, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
    }

    public int numSpecial(int[][] mat) {
        // O(N^2) 안에 해결할 수 있을 것으로 보입니다.
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        int answer = 0;
        for(int y = 0; y < mat.length; y++){
            for(int x = 0; x < mat[0].length; x++){
                // (x, y)
                if(mat[y][x] == 1){
                    // 검사한 이력이 있는지 확인하기
                    if(xSet.contains(x)){
                        ySet.add(y);
                        continue;
                    }
                    if(ySet.contains(y)){
                        xSet.add(x);
                        continue;
                    }
                    // 검사를 할거니까 set 에다가 추가를 해줍니다.
                    xSet.add(x);
                    ySet.add(y);
                    boolean yAllZero = true;
                    for(int i = y+1; i < mat.length; i++){
                        if(mat[i][x] == 1){
                            yAllZero = false;
                            break;
                        }
                    }
                    boolean xAllZero = true;
                    for(int i = x+1; i < mat[0].length; i++){
                        if(mat[y][i] == 1){
                            xAllZero = false;
                            break;
                        }
                    }
                    if(xAllZero && yAllZero){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
