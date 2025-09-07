package com.leetcode;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class Q1304_FindNUniqueIntegersSumuptoZero {

    @Test
    void test() {
        System.out.println("result : " + sumZero(1000));
    }

    public int[] sumZero(int n) {
        // 홀수면 0으로 좌우 대칭
        // 짝수면 좌우 대칭
        if(n == 1) return new int[]{0};

        int[] answer = new int[n];
        int min = n / 2 * -1;
        int max = n / 2;
        int idx = 0;
        if(n % 2 == 0){
            for(int i = min; i < 0; i++){
                answer[idx++] = i;
            }
            for(int i = 1; i <= max; i++){
                answer[idx++] = i;
            }
        } else {
            for(int i = min; i <= max; i++){
                answer[idx++] = i;
            }
        }
        return answer;
    }
}
