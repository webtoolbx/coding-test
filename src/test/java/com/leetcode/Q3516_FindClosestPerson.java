package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q3516_FindClosestPerson {

    @Test
    void test() {
        System.out.println("result : " + findClosest(3, 7,4));
    }

    public int findClosest(int x, int y, int z) {
        int diff1 = Math.abs(z - x);
        int diff2 = Math.abs(z - y);
        return diff1 > diff2 ? 2 : diff1 < diff2 ? 1 : 0;
    }
}
