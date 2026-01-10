package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q66_PlusOne {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        Assertions.assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));
        Assertions.assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
        Assertions.assertArrayEquals(new int[]{1, 0, 0}, plusOne(new int[]{9, 9}));
    }

    public int[] plusOne(int[] digits) {
        // 숫자 1더하기
        // 뒤에서부터 1더하고 역순으로 하면 될거 같은데
        // 배열의 크기를 마지막 요소가 9인지확인해야할거 같은데?
        // 모든 숫자가 9인 경우에만 해당되네 -> 이때만 배열 재선언해주자

        int n = digits.length;
        for(int i = n-1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // 리턴되지 않았다면 모든 자리가 0으로 만들어짐
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
