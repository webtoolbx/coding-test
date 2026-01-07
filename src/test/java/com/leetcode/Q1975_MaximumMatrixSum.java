package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q1975_MaximumMatrixSum {

    @Test
    void test() {

    }

    public long maxMatrixSum(int[][] matrix) {
        // 결국에 -개수가 2개면 합칠 수 있으니까
        // - 의 개수가 홀수인지 짝수인지
        // 모든 숫자들을 다 더하고
        // 절대값이 가장 작은 수는 후보로 만들어두고 마지막에 뺄셈

        long sum = 0;
        int small = 100000;
        boolean isEven = true;
        for(int[] i : matrix){
            for(int j : i){
                if(j < 0){
                    if(isEven){
                        isEven = false;
                    } else {
                        isEven = true;
                    }
                }
                int abs = Math.abs(j);
                sum += abs;
                if(abs < small){
                    small = abs;
                }
            }
        }

        if(!isEven){
            sum -= small * 2;
        }

        return sum;
    }
}
