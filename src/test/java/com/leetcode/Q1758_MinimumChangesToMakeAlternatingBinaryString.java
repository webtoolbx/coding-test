package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1758_MinimumChangesToMakeAlternatingBinaryString {

    @Test
    void test() {
        Assertions.assertEquals(1, minOperations("0100"));
        Assertions.assertEquals(0, minOperations("10"));
        Assertions.assertEquals(2, minOperations("1111"));
    }

    public int minOperations(String s) {
        // 2^10000이 되기 때문에 int 비트연산 불가
        int n = s.length();
        // 1과 0을 담을 배열을 생성
        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                arr[i] = true;
            }
        }

        // 배열 생성 완료
        // 1. 첫비트가 true 인 경우
        int firstTrue = 0;
        boolean flag = true;
        for (boolean b : arr) {
            if (flag ^ b) {
                firstTrue++;
            }
            flag = !flag;
        }

        int firstFalse = 0;
        flag = false;
        for (boolean b : arr) {
            if (b ^ flag) {
                firstFalse++;
            }
            flag = !flag;
        }

        // System.out.println(firstTrue);
        // System.out.println(firstFalse);

        return Math.min(firstTrue, firstFalse);
    }

}
