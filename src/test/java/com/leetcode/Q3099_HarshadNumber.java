package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q3099_HarshadNumber {

    @Test
    void test() {
        int result = sumOfTheDigitsOfHarshadNumber(18);
        System.out.println(result);
    }

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        if(x < 10){
            return x;
        } else if(x == 100){
            return 1;
        }
        // 10 ~ 99 의 숫자들
        int n = x % 10 + x / 10;
        return x % n == 0 ? n : -1;
    }
}
