package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q2976_MinimumCosttoConvertStringI {

    @Test
    void test() {
        Assertions.assertEquals(28, minimumCost("abcd", "acbe",
                new char[]{'a', 'b', 'c', 'c', 'e', 'd'},
                new char[]{'b', 'c', 'b', 'e', 'b', 'e'},
                new int[]{2, 5, 5, 1, 2, 20}));

        Assertions.assertEquals(12, minimumCost("aaaa", "bbbb",
                new char[]{'a', 'c'},
                new char[]{'c', 'b'},
                new int[]{1, 2}));

        Assertions.assertEquals(-1, minimumCost("abcd", "abce",
                new char[]{'a'},
                new char[]{'e'},
                new int[]{10000}));
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // a->b, a->c, b->c 가 있을 때 a->c 의 최소값을 기억
        // 큰 값들로 초기화
        long[][] dp = new long[26][26];
        for(int i = 0; i < 26; i++){
            Arrays.fill(dp[i], 1_000_000_000_000L);
            dp[i][i] = 0;
        }

        // 간선 정보들 입력
        for(int i = 0; i < original.length; i++){
            int org = original[i] - 'a';
            int dest = changed[i] - 'a';
            dp[org][dest] = Math.min(dp[org][dest], cost[i]);
        }

        // 이동 간선 처리
        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    if(dp[i][j] > dp[i][k] + dp[k][j]){
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        // for(int i = 0; i < dp.length; i++){
        //     for(int j = 0; j < dp[0].length; j++){
        //         System.out.println(dp[i][j]);
        //     }
        // }

        // 변환 처리
        long answer = 0;
        for(int i = 0; i < source.length(); i++){
            int org = source.charAt(i) - 'a';
            int dest = target.charAt(i) - 'a';
            if(dp[org][dest] >= 1_000_000_000_000L){
                return -1;
            }
            answer += dp[org][dest];
        }

        return answer;
    }
}
