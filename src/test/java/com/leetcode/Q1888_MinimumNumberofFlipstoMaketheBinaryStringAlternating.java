package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1888_MinimumNumberofFlipstoMaketheBinaryStringAlternating {

    @Test
    void test() {
        Assertions.assertEquals(2, minFlips("111000"));
        Assertions.assertEquals(0, minFlips("010"));
        Assertions.assertEquals(1, minFlips("1110"));
    }

    public int minFlips(String s) {
        // 바이너리 스트링이 주어지는데
        // 두 가지 방법이 가능하다
        // 타입1 첫번째 문자열을 떼다가 마지막으로 붙인다.
        // 타입2 아무 문자열을 선택해서 반전한다
        // 타입2를 가능한 적게 하고 싶다는거
        // 옆에 문자열이 동일하면 안된다

        // 타입1을 확인하기 위해서 문자열 s를 2개 붙여서 이동하면 가능
        int n = s.length();
        s = s + s;
        StringBuilder zeroFirst = new StringBuilder();
        StringBuilder oneFirst = new StringBuilder();
        for (int i = 0; i < n * 2; i++) {
            if (i % 2 == 0) {
                zeroFirst.append('0');
                oneFirst.append('1');
            } else {
                zeroFirst.append('1');
                oneFirst.append('0');
            }
        }
        // System.out.println(zeroFirst.toString());
        // System.out.println(oneFirst.toString());

        int min = Integer.MAX_VALUE;
        int diff1 = 0;
        int diff2 = 0;
        for (int i = 0; i < n * 2; i++) {
            if (s.charAt(i) != zeroFirst.charAt(i)) {
                diff1++;
            }
            if (s.charAt(i) != oneFirst.charAt(i)) {
                diff2++;
            }
            if (i >= n) {
                // n부터는 0부터 값 삭제 처리 필요
                if (s.charAt(i - n) != zeroFirst.charAt(i - n)) {
                    diff1--;
                }
                if (s.charAt(i - n) != oneFirst.charAt(i - n)) {
                    diff2--;
                }
            }
            if (i >= n - 1) {
                min = Math.min(min, diff1);
                min = Math.min(min, diff2);
            }
        }

        return min;
    }
}
