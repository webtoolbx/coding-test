package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q1137_NthTribonacciNumber {

    @Test
    void test() {
        System.out.println("result : " + tribonacci(10));
    }

    public int tribonacci(int n) {
        if(n == 0) return 0;
        int[] arr = new int[]{1,1,2};
        if(n < 4){
            return arr[n-1];
        }

        for(int i = 4; i <= n; i++){
            int next = arr[0] + arr[1] + arr[2];
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = next;
        }
        return arr[2];
    }
}
