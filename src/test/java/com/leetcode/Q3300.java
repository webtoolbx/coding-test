package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3300 {

    @Test
    void testMinElement() {
        Q3300 q = new Q3300();
        Assertions.assertEquals(6, q.minElement(new int[]{15, 42, 8, 99}));
        Assertions.assertEquals(1, q.minElement(new int[]{100, 10, 1}));
        Assertions.assertEquals(9, q.minElement(new int[]{9}));
        Assertions.assertEquals(1, q.minElement(new int[]{1, 1, 1, 1}));
        Assertions.assertEquals(1, q.minElement(new int[]{12345, 54321, 10000}));
    }

    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int num = nums[i];
            while(num != 0){
                sum += num % 10;
                num /= 10;
            }
            min = Math.min(min, sum);
        }

        return min;
    }
}
