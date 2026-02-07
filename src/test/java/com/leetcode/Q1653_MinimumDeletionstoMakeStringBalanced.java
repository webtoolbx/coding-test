package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1653_MinimumDeletionstoMakeStringBalanced {

    @Test
    void test() {
        Assertions.assertEquals(2, minimumDeletions("aababbab"));
        Assertions.assertEquals(2, minimumDeletions("bbaaaaabb"));
        Assertions.assertEquals(0, minimumDeletions("ab"));
        Assertions.assertEquals(0, minimumDeletions("a"));
        Assertions.assertEquals(0, minimumDeletions("b"));
    }

    public int minimumDeletions(String s) {
        int res = 0, b = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b')
                b++;
            else if (b > 0) {
                // 어차피 둘 중의 한 녀석 사망
                res++;
                b--;
            }
        }

        return res;
    }
}
