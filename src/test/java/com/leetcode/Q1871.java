package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1871 {

    @Test
    void testCanReach() {
        Q1871 q = new Q1871();

        // Test case 1: Basic reachable
        Assertions.assertTrue(q.canReach("011010", 2, 3));

        // Test case 2: Basic unreachable
        Assertions.assertFalse(q.canReach("011011", 2, 3));

        // Test case 3: Target is '1'
        Assertions.assertFalse(q.canReach("01101", 2, 3)); // The original code has a bug here, it should be '0' at the end to reach.

        // Test case 4: Only '0's
        Assertions.assertTrue(q.canReach("00000", 1, 2));

        // Test case 5: Only '0's, but minJump too large
        Assertions.assertFalse(q.canReach("00000", 5, 5));

        // Test case 6: Long string, reachable
        Assertions.assertTrue(q.canReach("0000000000", 2, 4));

        // Test case 7: Long string, unreachable due to '1's blocking path
        Assertions.assertFalse(q.canReach("00100100", 2, 3));

        // Test case 8: minJump == maxJump
        Assertions.assertTrue(q.canReach("00000", 2, 2));
        Assertions.assertFalse(q.canReach("00100", 2, 2));

        // Test case 9: Smallest possible string
        Assertions.assertTrue(q.canReach("0", 1, 1)); // Should be true as start is 0 and length is 1.
        Assertions.assertFalse(q.canReach("01", 1, 1)); // Cannot reach '1' at the end.
        Assertions.assertTrue(q.canReach("00", 1, 1)); // Can reach '0' at index 1.
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        int size = s.length();
        boolean[] dp = new boolean[size];
        dp[0] = true;

        // The problem statement implies s.charAt(size - 1) must be '0' to reach.
        // If the last character is '1', it's impossible to land on it.
        if (s.charAt(size - 1) == '1') { // Corrected condition
            return false;
        }

        int reachCount = 0;
        for (int i = 1; i < size; i++) {
            // Add count for positions that can reach current 'i'
            if (i >= minJump && dp[i - minJump]) {
                reachCount++;
            }
            // Remove count for positions that are too far to reach current 'i'
            if (i > maxJump && dp[i - maxJump - 1]) {
                reachCount--;
            }

            if (s.charAt(i) == '0' && reachCount > 0) {
                dp[i] = true;
            }
        }

        return dp[size - 1];
    }
}
