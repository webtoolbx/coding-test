package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q3090 {


    // 테스트 코드
    @Test
    void test() {
        Q3090 solver = new Q3090();

        // 케이스 1: 일반적인 경우
        // "bcbbbcba" -> "bcbb" (길이 4)
        Assertions.assertEquals(4, solver.maximumLengthSubstring("bcbbbcba"));

        // 케이스 2: 중복이 없는 경우
        // "aaaa" -> "aa" (길이 2)
        Assertions.assertEquals(2, solver.maximumLengthSubstring("aaaa"));

        // 케이스 3: 전체가 중복 없이 이어지는 경우
        Assertions.assertEquals(3, solver.maximumLengthSubstring("abc"));

        // 케이스 4: 짧은 문자열
        Assertions.assertEquals(1, solver.maximumLengthSubstring("a"));

        // 케이스 5: 모든 문자가 2번씩 반복
        Assertions.assertEquals(6, solver.maximumLengthSubstring("aabbcc"));

        // 케이스 6: 복잡한 패턴
        Assertions.assertEquals(5, solver.maximumLengthSubstring("abacaba"));
    }

    public int maximumLengthSubstring(String s) {
        int result = 0;
        int left = 0;
        int[] count = new int[26];
        for(int right = 0; right < s.length(); right++){
            int rChar = s.charAt(right) - 'a';
            count[rChar]++;

            // check
            while(count[rChar] > 2){
                count[s.charAt(left) - 'a']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
