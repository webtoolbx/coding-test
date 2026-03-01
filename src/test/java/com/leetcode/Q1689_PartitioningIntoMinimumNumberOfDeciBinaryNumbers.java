package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    @Test
    void test() {
        Q1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers solution = new Q1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
        Assertions.assertEquals(3, solution.minPartitions("32"));
        Assertions.assertEquals(8, solution.minPartitions("82734"));
        Assertions.assertEquals(9, solution.minPartitions("27346209830709182346"));
    }

    public int minPartitions(String n) {
        int max = 0;
        for(char c : n.toCharArray()){
            max = Math.max(max, c - '0');
            if(max == 9) return max;
        }
        return max;
    }
}
