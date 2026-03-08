package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1980_FindUniqueBinaryString {

    @Test
    void test() {
        Assertions.assertEquals("11", findDifferentBinaryString(new String[]{"01", "10"}));
        Assertions.assertEquals("10", findDifferentBinaryString(new String[]{"00", "01"}));
        Assertions.assertEquals("000", findDifferentBinaryString(new String[]{"111", "011", "001"}));
    }

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // i번째 문자열의 i번째 문자를 가져와서 반대로 뒤집음
            char c = nums[i].charAt(i);
            sb.append(c == '0' ? '1' : '0');
        }

        return sb.toString();
    }
}
