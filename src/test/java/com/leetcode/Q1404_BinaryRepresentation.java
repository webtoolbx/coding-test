package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Q1404_BinaryRepresentation {

    @Test
    void test() {
        Assertions.assertEquals(6, numSteps("1101"));
        Assertions.assertEquals(1, numSteps("10"));
        Assertions.assertEquals(0, numSteps("1"));
    }

    public int numSteps(String s) {
        // 1만들기
        // 맨 오른쪽이 0이면 >> 한칸 줄이고
        // 맨 오른쪽이 1이면 1더하면 되는거 아냐?
        BigInteger bi = new BigInteger(s, 2);
        int step = 0;
        while (!BigInteger.ONE.equals(bi)) {
            step++;
            if (bi.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                bi = bi.divide(BigInteger.TWO);
            } else {
                bi = bi.add(BigInteger.ONE);
            }
        }

        return step;
    }
}
