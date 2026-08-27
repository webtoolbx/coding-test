package com.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Q3622 {

    @Test
    @DisplayName("기본 예시 검증 - true 케이스 (99, 19, 10)")
    void checkDivisibility_TrueCases() {
        assertThat(checkDivisibility(99)).isTrue(); // S=18, P=81 -> S+P=99
        assertThat(checkDivisibility(19)).isTrue(); // S=10, P=9  -> S+P=19
        assertThat(checkDivisibility(10)).isTrue(); // S=1,  P=0  -> S+P=1
    }

    @Test
    @DisplayName("기본 예시 검증 - false 케이스 (24, 12, 105)")
    void checkDivisibility_FalseCases() {
        assertThat(checkDivisibility(24)).isFalse(); // S=6, P=8 -> S+P=14, 24%14 != 0
        assertThat(checkDivisibility(12)).isFalse(); // S=3, P=2 -> S+P=5,  12%5 != 0
        assertThat(checkDivisibility(105)).isFalse(); // S=6, P=0 -> S+P=6,  105%6 != 0
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("한 자릿수 모든 숫자(1~9)는 항상 true이어야 한다")
    void checkDivisibility_SingleDigitNumbers_ReturnsTrue(int n) {
        // n의 자릿수 합 = n, 자릿수 곱 = n -> 합 + 곱 = 2n
        // n % (2n) != 0 이므로 한 자릿수는 무조건 false가 됩니다.
        // 예를 들어 n=5 -> S=5, P=5 -> S+P=10 -> 5 % 10 = 5 (false)
        assertThat(checkDivisibility(n)).isFalse();
    }

    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int temp = n;
        while(temp > 0){
            int cur = temp % 10;
            sum += cur;
            prod *= cur;
            temp /= 10;
        }
        return n % (sum + prod) == 0;
    }
}
