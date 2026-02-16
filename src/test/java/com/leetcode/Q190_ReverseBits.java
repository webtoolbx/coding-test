package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q190_ReverseBits {

    @Test
    void test() {
        Assertions.assertEquals(964176192, reverseBits(43261596));
        Assertions.assertEquals(-1073741825, reverseBits(-3));
    }

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits2(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }

        return res;
    }
}
