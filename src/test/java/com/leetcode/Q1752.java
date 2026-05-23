package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1752 {

    @Test
    void testCheck() {
        Q1752 q = new Q1752();
        Assertions.assertTrue(q.check(new int[]{3, 4, 5, 1, 2}));
        Assertions.assertFalse(q.check(new int[]{2, 1, 3, 4}));
        Assertions.assertTrue(q.check(new int[]{1, 2, 3}));
        Assertions.assertTrue(q.check(new int[]{1, 1, 1}));
        Assertions.assertTrue(q.check(new int[]{2, 1}));
        Assertions.assertTrue(q.check(new int[]{1}));
    }

    public boolean check(int[] nums) {
        // 배열 2개를 붙여서 정렬된건지 확인 가능
        // 3 4 5 [1 2 3 4 5] 1 2
        if (nums.length == 1) {
            return true;
        }

        int size = nums.length;
        int counter = 0; // counter
        for (int i = 0; i < size * 2; i++) {
            int cur = nums[i % size];
            int next = nums[(i + 1) % size];
            if (cur > next) {
                counter = 0;
            } else {
                counter++;
            }
            // System.out.println(counter);
            if (counter == size - 1) {
                return true;
            }
        }
        return false;
    }
}
