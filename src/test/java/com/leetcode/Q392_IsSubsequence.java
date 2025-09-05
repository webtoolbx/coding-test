package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q392_IsSubsequence {

    @Test
    void test() {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        if(sArr.length == 0) return true;
        if(tArr.length == 0) return false;

        int i1 = 0;
        int i2 = 0;

        while(i2 < tArr.length){
            if(sArr[i1] == tArr[i2]){
                i1++;
                i2++;
            } else {
                i2++;
            }

            if(i1 == sArr.length){
                return true;
            }
        }

        return false;
    }
}
