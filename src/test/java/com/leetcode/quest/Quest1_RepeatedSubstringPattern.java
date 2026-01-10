package com.leetcode.quest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Quest1_RepeatedSubstringPattern {

    @Test
    void test() {
        Assertions.assertTrue(repeatedSubstringPattern("abab"));
        Assertions.assertFalse(repeatedSubstringPattern("aba"));
        Assertions.assertTrue(repeatedSubstringPattern("abcabcabcabc"));
    }

    // #Easy
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}
