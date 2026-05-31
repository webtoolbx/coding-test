package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3121 {

    @Test
    void testNumberOfSpecialChars() {
        Q3121 solution = new Q3121();
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
                // bBit 이 이미 1이라면 sBit 0으로
                // bBit 이 0이라면 sBit 1로 설정
                int target = 1 << (c - 'a');
                if((bBit & target) == 0){
                    sBit |= target;
                } else {
                    int mask = ~target;
                    sBit &= mask;
                }
            } else {
                bBit |= 1 << (c - 'A');
            }
        }

        return Integer.bitCount(sBit & bBit);
    }
}