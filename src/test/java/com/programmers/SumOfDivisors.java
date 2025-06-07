package com.programmers;

import org.junit.jupiter.api.Test;

public class SumOfDivisors {

    @Test
    void sumOfDivisors() {
        System.out.println(solution(0)); // 0
        System.out.println(solution(1)); // 1
        System.out.println(solution(2)); // 3
        System.out.println(solution(12)); // 28
        System.out.println(solution(5));  // 6
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++){
            if (n % i == 0) {
                answer += i; // i는 약수
                if(i != n / i) {
                    answer += n / i; // n / i는 약수
                }                
            }
        }
        return answer;
    }
}
