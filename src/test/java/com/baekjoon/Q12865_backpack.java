package com.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class Q12865_backpack {

    @Test
    void test() {

        int N = 4;
        int K = 7;

        int[] W = new int[]{6, 4, 3, 8};
        int[] V = new int[]{13,8,6,12};
        
        int[] dp = new int[K + 1]; // dp[j] = 무게 j일 때 최대 가치, 처음엔 0으로 초기화됨

        // 각 물건을 하나씩 보면서
        for (int i = 0; i < N; i++) {
            // 무게를 K부터 W[i]까지 거꾸로 확인
            // 거꾸로 해야 이미 이전 물건으로 계산된 dp 값이 덮어지지 않고 올바른 값 유지 가능
            for (int j = K; j >= W[i]; j--) {
                // 물건 i를 넣는 경우와 안 넣는 경우 중 최대값으로 dp[j] 갱신
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
                System.out.println(dp[j] + " ");
            }
            System.out.println("--------");
        }

        System.out.println(dp[K]); // 최대 무게 K일 때 가능한 최대 가치를 출력
    }
}
