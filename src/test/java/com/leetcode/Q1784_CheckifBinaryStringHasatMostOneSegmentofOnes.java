package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1784_CheckifBinaryStringHasatMostOneSegmentofOnes {

    @Test
    void test() {
        Assertions.assertFalse(checkOnesSegment("1001"));
        Assertions.assertTrue(checkOnesSegment("110"));
    }

    public boolean checkOnesSegment(String s) {
        // 앞에서부터 체크했을때 1 -> 0 은 괜찮은데 1 -> 0 -> 1
        // 0이 한번이라도 등장했다면 1이 등장해서는 안된다.

        // int long 으로 비트연산은 100까지 있기 때문에 불가
        // 0를 한번 찾고 그 뒤에 1이 한번이라도 존재한다면 실패 처리
        boolean hasZero = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                hasZero = true;
            } else if (hasZero) {
                return false;
            }
        }

        return true;
    }
}
