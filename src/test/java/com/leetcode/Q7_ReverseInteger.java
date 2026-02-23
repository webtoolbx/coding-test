package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q7_ReverseInteger {

    @Test
    void test() {
        Q7_ReverseInteger solution = new Q7_ReverseInteger();
        Assertions.assertEquals(321, solution.reverse(123));
        Assertions.assertEquals(-321, solution.reverse(-123));
        Assertions.assertEquals(21, solution.reverse(120));
        Assertions.assertEquals(0, solution.reverse(0));
        Assertions.assertEquals(0, solution.reverse(1534236469)); // Overflow case
    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0; // Math.abs(Integer.MIN_VALUE) is undefined for int
        int abs = Math.abs(x);
        StringBuilder sb = new StringBuilder();
        while(abs > 0){
            sb.append(abs % 10);
            abs /= 10;
        }
        if(sb.length() == 0) return 0;
        // System.out.println(sb.toString());
        long v = Long.parseLong(sb.toString());
        if(v > Integer.MAX_VALUE) return 0;

        return x > 0 ? (int)v : (int)(-1 * v);
    }
}
