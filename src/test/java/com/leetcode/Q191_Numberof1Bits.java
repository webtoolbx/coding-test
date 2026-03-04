package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q191_Numberof1Bits {

    @Test
    void test() {
        Q191_Numberof1Bits solution = new Q191_Numberof1Bits();
        Assertions.assertEquals(3, solution.hammingWeight(11));
        Assertions.assertEquals(1, solution.hammingWeight(128));
        Assertions.assertEquals(31, solution.hammingWeight(-3));
    }

    public int hammingWeight(int n) {
        int answer = 0;

        // n이 될때가지 shift 연산 진행
        while(n != 0){
            if((n & 1) == 1){
                answer++;
            }
            n = n >>> 1; // Unsigned right shift
        }
        return answer;
    }
}
