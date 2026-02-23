package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q799_ChampagneTower {

    @Test
    void test() {
        Q799_ChampagneTower solution = new Q799_ChampagneTower();
        Assertions.assertEquals(0.0, solution.champagneTower(1, 1, 1));
        Assertions.assertEquals(0.5, solution.champagneTower(2, 1, 1));
        Assertions.assertEquals(1.0, solution.champagneTower(100000009, 33, 17));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        // pooured 붓는 횟수
        // query_row 에 query_glass 가 얼마나 찼는지 계산하기
        // 그 이상 떨어지는 경우에는 버리겠구나

        // 숫자를 증가시키면서 계산을 시켜야 하나
        // 1일 때 첫번째 배열에 차고
        double[][] cup = new double[102][102];
        cup[0][0] = (double) poured;

        for(int r = 0; r <= query_row; r++){
            for(int c = 0; c <= r; c++){
                // 그 컵이 1 이상인 경우 아래 컵으로 분산
                if(cup[r][c] > 1.0){
                    double exceed = (cup[r][c] - 1.0) / 2.0;
                    cup[r][c] = 1.0;
                    cup[r+1][c] += exceed;
                    cup[r+1][c+1] += exceed;
                }
            }
        }

        return cup[query_row][query_glass];
    }
}
