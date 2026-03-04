package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q136_SingleNumber {

    @Test
    void test() {
        Q136_SingleNumber solution = new Q136_SingleNumber();
        Assertions.assertEquals(1, solution.singleNumber(new int[]{2, 2, 1}));
        Assertions.assertEquals(4, solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
        Assertions.assertEquals(1, solution.singleNumber(new int[]{1}));
    }

    public int singleNumber(int[] nums) {
        // XOR 연산을 사용하면 됩니다.
        int answer = 0;
        for(int n : nums){
            answer ^= n;
        }
        return answer;
    }
}
