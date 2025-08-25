package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q338_CountingBits {

    @Test
    void test() {
        System.out.println("result : " + countBits(6));
    }

    public int[] countBits(int n) {
        // 0 1 1 2 1 2 2 3
        int[] arr = new int[n+1];
        for(int i = 0; i <= n; i++){
            arr[i] = Integer.bitCount(i);
        }
        return arr;
    }
}
