package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q14_LongestCommonPrefix {

    @Test
    void test() {
        Q14_LongestCommonPrefix solution = new Q14_LongestCommonPrefix();
        Assertions.assertEquals("fl", solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assertions.assertEquals("", solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int min = 200;
        for(String s : strs){
            min = Math.min(min, s.length());
        }
        StringBuilder sb = new StringBuilder();
        Character c = null;
        for(int i = 0; i < min; i++){
            for(String s : strs){
                if(c == null){
                    c = s.charAt(i);
                } else {
                    if(c != s.charAt(i)){
                        return sb.toString();
                    }
                }
            }
            sb.append(c);
            c = null;
        }
        return sb.toString();
    }
}
