package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q961_NRepeatedElementinSize2NArray {

    @Test
    void test() {
        Assertions.assertEquals(3, repeatedNTimes(new int[]{1, 2, 3, 3}));
        Assertions.assertEquals(2, repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        Assertions.assertEquals(5, repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n)){
                return n;
            }
            set.add(n);
        }
        return -1;
    }
}
