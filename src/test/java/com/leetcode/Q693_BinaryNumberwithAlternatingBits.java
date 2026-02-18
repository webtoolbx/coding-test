package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q693_BinaryNumberwithAlternatingBits {

    @Test
    void test() {
        Q693_BinaryNumberwithAlternatingBits solution = new Q693_BinaryNumberwithAlternatingBits();
        Assertions.assertTrue(solution.hasAlternatingBits(5));
        Assertions.assertFalse(solution.hasAlternatingBits(7));
        Assertions.assertFalse(solution.hasAlternatingBits(11));
    }

    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                return false;
            }
        }

        return true;
    }
}
