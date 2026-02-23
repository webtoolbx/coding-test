package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q1461_CheckIfaStringContainsAllBinaryCodesofSizeK {

    @Test
    void test() {
        Assertions.assertTrue(hasAllCodes("00110110", 2));
        Assertions.assertTrue(hasAllCodes("0110", 1));
        Assertions.assertFalse(hasAllCodes("0110", 2));
    }

    public boolean hasAllCodes(String s, int k) {
        // length 가 5 * 10^5 이라면 그 개수만큼의 쌍이 생성된다
        // k 를 만들면 2^20 개수만큼의 쌍이 생성
        // 얘네들아 전부다 있는지 체크?
        Set<String> set = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++){
            set.add(s.substring(i, i + k));
        }

        // System.out.println(set.toString());

        for(int i = 0; i < Math.pow(2, k); i++){
            String cur = Integer.toBinaryString(i);
            cur = "0".repeat(k - cur.length()) + cur;
            if(!set.contains(cur)) return false;
        }

        return true;
    }
}
