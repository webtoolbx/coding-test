package com.leetcode.quest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Quest3_RepeatedStringMatch {

    @Test
    void test() {
        Assertions.assertEquals(3, repeatedStringMatch("abcd", "cdabcdab"));
        Assertions.assertEquals(2, repeatedStringMatch("a", "aa"));
        Assertions.assertEquals(-1, repeatedStringMatch("a", "b"));
        Assertions.assertEquals(4, repeatedStringMatch("abc", "cabcabca"));
    }

    // #Easy
    public int repeatedStringMatch(String a, String b) {
        // 크기가 동일해졌을때? 동일 사이즈보다 한번만 더 클때?
        StringBuilder sb = new StringBuilder(a);
        int cnt = 1;
        while(sb.length() < b.length()){
            sb.append(a);
            cnt++;
        }
        if(sb.toString().contains(b)){
            return cnt;
        }

        // 한번 더 기회를 준다
        sb.append(a);
        if(sb.toString().contains(b)){
            return cnt+1;
        }
        return -1;
    }
}
