package com.leetcode.quest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Quest2_RotateString {

    @Test
    void test() {
        Assertions.assertTrue(rotateString("abcde", "cdeab"));
        Assertions.assertFalse(rotateString("abcde", "abced"));
    }

    // #Easy
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)){
            return true;
        }
        if(s.length() != goal.length()){
            return false;
        }
        for(int shift = 1; shift < s.length(); shift++){
            boolean isValid = true;
            for(int i = 0; i < s.length(); i++){
                int n = (i + shift) % s.length();
                if(s.charAt(i) != goal.charAt(n)){
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                return true;
            }
        }
        return false;
    }
}
