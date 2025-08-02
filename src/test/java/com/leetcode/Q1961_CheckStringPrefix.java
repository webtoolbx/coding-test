package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q1961_CheckStringPrefix {

    @Test
    void test() {
        boolean result = isPrefixString("iloveleetcode", new String[]{"i","love","leetcode","apples"});
        System.out.println("result : " + result);
    }

    public boolean isPrefixString(String s, String[] words) {
        int fromIndex = 0;
        int sLength = s.length();
        for (String word : words) {
            int cur = s.indexOf(word, fromIndex);
            if (cur != fromIndex) {
                return false;
            }
            fromIndex = cur + word.length();
            if(fromIndex == sLength){
                return true;
            }
        }
        return false;
    }
}
