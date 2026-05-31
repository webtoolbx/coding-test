package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3120 {

    @Test
    void testNumberOfSpecialChars() {
        Q3120 solution = new Q3120();
        Assertions.assertEquals(3, solution.numberOfSpecialChars("aaAbcBC"));
        Assertions.assertEquals(0, solution.numberOfSpecialChars("abc"));
        Assertions.assertEquals(0, solution.numberOfSpecialChars("abBCab")); // 소문자가 대문자 뒤에 나옴
        Assertions.assertEquals(1, solution.numberOfSpecialChars("cCceDc")); // LeetCode 3120번 문제 조건에 맞추려면 대소문자가 모두 있어야 함
    }

    public int numberOfSpecialChars(String word) {
        int sBit = 0;
        int bBit = 0;

        for(char c : word.toCharArray()){
            if(c >= 'a'){
                sBit = sBit | 1 << (c - 'a');
            } else {
                bBit = bBit | 1 << (c - 'A');
            }
        }

        return Integer.bitCount(sBit & bBit);
    }
}