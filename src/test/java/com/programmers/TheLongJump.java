package com.programmers;

import org.junit.jupiter.api.Test;

public class TheLongJump {

    @Test
    void theLongJump() {
        System.out.println(solution(4)); // 0
        System.out.println(solution(1)); // 1
        System.out.println(solution(2)); // 3
        System.out.println(solution(12)); // 28
        System.out.println(solution(3000));  // 6
    }

    public long solution(int n) {
        long[] dp = new long[n+1];
        return fibonacci(n, dp);
    }
    
    private long fibonacci(int n, long[] dp){
        int num = 1234567;
        if(n <= 1) {
            dp[n] = 1;
        } else if(dp[n] == 0){
            dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp);
        }
        
        return dp[n] % num;
    }
}
